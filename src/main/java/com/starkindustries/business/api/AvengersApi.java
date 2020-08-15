package com.starkindustries.business.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

public interface AvengersApi<T,I>{
	@PostMapping("avengers")
	ResponseEntity<?> save(String t,MultipartFile file);

	@GetMapping("avengers")
	ResponseEntity<?> findAll();
	
	@GetMapping("avengers/{id}")
	ResponseEntity<?> findById(I i);

}
