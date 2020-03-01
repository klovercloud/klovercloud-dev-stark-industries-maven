package com.starkindustries.business.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starkindustries.business.service.S3Service;
import com.starkindustries.business.service.StaffService;
import com.starkindustries.data.Staff;
import com.starkindustries.data.repository.StaffRepository;

@Service
public class StaffServiceImplementation implements StaffService<Staff, String> {

	@Autowired
	StaffRepository staffRepository;
	
	@Autowired
	S3Service s3Service;

	@Override
	public void save(Staff staff) throws Exception {
		try {
			staffRepository.save(staff);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Staff> findAll() {
		List<Staff> staffs=new ArrayList<Staff>();
		staffs=staffRepository.findAll();
		staffs.stream().forEach(staff->{
			try {
				staff.setImage(s3Service.findByKeyName(staff.getImageName()).toByteArray());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		return staffs;
	}

	@Override
	public Staff findById(String id) {
		try {
			Staff staff=new Staff();
			staff=staffRepository.findById(id).get();
			staff.setImage(s3Service.findByKeyName(staff.getImageName()).toByteArray());
			return staff;
		}catch(Exception e ) {
			return null;
		}
	}

}