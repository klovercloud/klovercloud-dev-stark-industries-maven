package com.starkindustries.business.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starkindustries.business.api.AvengersApi;
import com.starkindustries.business.service.AvengersService;
import com.starkindustries.data.Avengers;

@RestController
@RequestMapping("api/v1/")
public class StaffApiImplementation implements AvengersApi<Avengers, String>{
	
	@Autowired
	AvengersService staffService;

	@Override
	public ResponseEntity<?> save(@RequestBody Avengers staff) {
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
		Avengers staff=(Avengers) staffService.findById(id);
		if(staff==null) {
			return ResponseEntity.ok().body("No record found!");
		}
		return ResponseEntity.ok().body(staff);
	}

}