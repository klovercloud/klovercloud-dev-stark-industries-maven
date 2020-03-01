package com.starkindustries.business.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("s3s")
public interface S3Api {
	
	@PostMapping("/")
	ResponseEntity<?> uploadMultipartFile(MultipartFile file);
	
	@GetMapping("/{keyname}")
	public ResponseEntity<?> downloadFile( String keyname);
		
	

}
