package com.starkindustries.business.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


public interface S3Api {
	
	@PostMapping("s3s")
	ResponseEntity<?> uploadMultipartFile(MultipartFile file);
	
	@GetMapping("s3s/{keyname}")
	public ResponseEntity<byte[]> downloadFile( String keyname);
		
	

}
