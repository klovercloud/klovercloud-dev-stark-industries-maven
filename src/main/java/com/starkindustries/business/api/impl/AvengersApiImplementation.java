package com.starkindustries.business.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.starkindustries.business.api.AvengersApi;
import com.starkindustries.business.dto.Avenger;
import com.starkindustries.business.service.AvengersService;


@RestController
@RequestMapping("api/v1/")
public class AvengersApiImplementation implements AvengersApi<Avenger, String>{
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	AvengersService avengersService;

	@Override
	public ResponseEntity<?> save(@RequestBody Avenger staff) {
		try {
			avengersService.save(staff);
			return ResponseEntity.accepted().body("Operation Successful");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("[ERROR]:"+e.getMessage()+"Operation Failed!");
		}
	}

	@Override
	public ResponseEntity<?> findAll() {
		List<Avenger> avengers=avengersService.findAll();
		return ResponseEntity.ok().body(avengers);
	}

	@Override
	public ResponseEntity<?> findById(@PathVariable("id") String id) {
		Avenger staff=(Avenger) avengersService.findById(id);
		if(staff==null) {
			return ResponseEntity.ok().body("[ERROR]:"+"No record found!");
		}
		return ResponseEntity.ok().body(staff);
	}

}