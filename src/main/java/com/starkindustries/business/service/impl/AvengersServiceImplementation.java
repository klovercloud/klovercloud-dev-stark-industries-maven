package com.starkindustries.business.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.starkindustries.business.service.S3Service;
import com.starkindustries.business.dto.Avenger;
import com.starkindustries.business.service.AvengersService;
import com.starkindustries.data.Avengers;
import com.starkindustries.data.repository.AvengersRepository;

@Service
public class AvengersServiceImplementation implements AvengersService<Avenger, String> {

	@Autowired
	AvengersRepository avengersRepository;

	@Autowired
	S3Service s3Service;

	
	@Override
	//@CacheEvict(cacheNames = "avengers", allEntries=true)
	public void save(Avenger avenger) throws Exception {
		try {
			avengersRepository.save(Avengers.getAvengers(avenger));
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	//@Cacheable(cacheNames = "avengers")
	public List<Avenger> findAll() {
		List<Avengers> avengers_list = new ArrayList<Avengers>();
		List<Avenger> avenger_list = new ArrayList<Avenger>();
		avengers_list = avengersRepository.findAll();
		avengers_list.stream().forEach(avengers -> {
			byte[] image = null;
			try {
				ByteArrayOutputStream stream = s3Service.findByKeyName(avengers.getImageName());
				image=stream.toByteArray();
			} catch (Exception e) {}
			
			Avenger avenger=Avenger.getAvenger(avengers);
			avenger.setImage(image);
			avenger_list.add(avenger);
		
		});
		return avenger_list;
	}

	@Override
	//@Cacheable(cacheNames = "avengers", key = "#id")
	public Avenger findById(String id) {
		Avenger avenger = new Avenger();
		Avengers avengers = new Avengers();
		avengers = avengersRepository.findById(id).get();
		avenger=Avenger.getAvenger(avengers);

			try {	
			byte[] image = null;
				ByteArrayOutputStream stream = s3Service.findByKeyName(avengers.getImageName());
				image=stream.toByteArray();
	
			avenger.setImage(image);
			return avenger;
		} catch (Exception e) {
		
		}
	return avenger;
	}
	

}
