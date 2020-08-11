package com.starkindustries.business.api;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface AvengersApi<T,I>{
	@PostMapping("avengers")
	ResponseEntity<?> save(T t);

	@GetMapping("avengers")
	ResponseEntity<?> findAll();
	
	@GetMapping("avengers/{id}")
	ResponseEntity<?> findById(I i);

}
