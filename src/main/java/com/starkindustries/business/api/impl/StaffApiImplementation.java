package com.starkindustries.business.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starkindustries.business.api.StaffApi;
import com.starkindustries.business.service.StaffService;
import com.starkindustries.data.Staff;

@RestController
@RequestMapping("api/v1/")
public class StaffApiImplementation implements StaffApi<Staff, String>{
	
	@Autowired
	StaffService staffService;

	@Override
	public ResponseEntity<?> save(@RequestBody Staff staff) {
		try {
			staffService.save(staff);
			return ResponseEntity.accepted().body("Operation Successful");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Operation Failed!");
		}
	}

	@Override
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(staffService.findAll());
	}

	@Override
	public ResponseEntity<?> findById(@PathVariable("id") String id) {
		Staff staff=(Staff) staffService.findById(id);
		if(staff==null) {
			return ResponseEntity.ok().body("No record found!");
		}
		return ResponseEntity.ok().body(staff);
	}

}
