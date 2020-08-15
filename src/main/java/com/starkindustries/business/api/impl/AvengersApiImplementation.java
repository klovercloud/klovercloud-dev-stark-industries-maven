package com.starkindustries.business.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starkindustries.business.api.AvengersApi;
import com.starkindustries.business.dto.Avenger;
import com.starkindustries.business.service.AvengersService;
import com.starkindustries.business.service.S3Service;

@RestController
@RequestMapping("api/v1/")
public class AvengersApiImplementation implements AvengersApi<Avenger, String> {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	AvengersService avengersService;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	S3Service s3Service;

	@Override
	public ResponseEntity<String> save(@RequestParam(value = "avenger", required = true) String avenger,
			@RequestParam(required = true, value = "file") MultipartFile file) {

		try {
			Avenger data = objectMapper.readValue(avenger, Avenger.class);
			data.setImageName(file.getOriginalFilename());
			avengersService.save(data);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("[ERROR]:" + e.getMessage() + "Operation Failed!");
		}
		try {
			s3Service.uploadFile(file.getOriginalFilename(), file);
			return ResponseEntity.ok().body("Operation Successful!");
		} catch (IOException e) {
			return ResponseEntity.badRequest().body("Avengers data has been persisted! but Failed to upload files!");
		}

	}

	@Override
	public ResponseEntity<?> findAll() {
		List<Avenger> avengers = avengersService.findAll();
		return ResponseEntity.ok().body(avengers);
	}

	@Override
	public ResponseEntity<?> findById(@PathVariable("id") String id) {
		Avenger staff = (Avenger) avengersService.findById(id);
		if (staff == null) {
			return ResponseEntity.ok().body("[ERROR]:" + "No record found!");
		}
		return ResponseEntity.ok().body(staff);
	}

}