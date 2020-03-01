package com.starkindustries.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starkindustries.business.service.StaffService;
import com.starkindustries.data.Staff;
import com.starkindustries.data.repository.StaffRepository;

@Service
public class StaffServiceImplementation implements StaffService<Staff, String> {

	@Autowired
	StaffRepository staffRepository;

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
		return staffRepository.findAll();
	}

	@Override
	public Staff findById(String id) {
		try {
		return staffRepository.findById(id).get();
		}catch(Exception e ) {
			return null;
		}
	}

}
