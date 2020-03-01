package com.starkindustries.business.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface StaffApi<T,I>{
	@PostMapping("staffs")
	ResponseEntity<?> save(T t);

	@GetMapping("staffs")
	ResponseEntity<?> findAll();
	
	@GetMapping("staffs/{id}")
	ResponseEntity<?> findById(I i);

}
