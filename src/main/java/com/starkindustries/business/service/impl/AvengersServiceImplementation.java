package com.starkindustries.business.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starkindustries.business.service.S3Service;
import com.starkindustries.business.service.AvengersService;
import com.starkindustries.data.Avengers;
import com.starkindustries.data.repository.AvengersRepository;

@Service
public class AvengersServiceImplementation implements AvengersService<Avengers, String> {

	@Autowired
	AvengersRepository avengersRepository;

	@Autowired
	S3Service s3Service;

	@Override
	public void save(Avengers staff) throws Exception {
		try {
			avengersRepository.save(staff);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Avengers> findAll() {
		List<Avengers> staffs = new ArrayList<Avengers>();
		staffs = avengersRepository.findAll();
		staffs.stream().forEach(staff -> {
			byte[] image = null;
			try {
				ByteArrayOutputStream stream = s3Service.findByKeyName(staff.getImageName());
				image=stream.toByteArray();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			staff.setImage(image);
		});
		return staffs;
	}

	@Override
	public Avengers findById(String id) {
		try {
			Avengers staff = new Avengers();
			staff = avengersRepository.findById(id).get();
			staff.setImage(s3Service.findByKeyName(staff.getImageName()).toByteArray());
			return staff;
		} catch (Exception e) {
			return null;
		}
	}

}