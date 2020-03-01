package com.starkindustries.business.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {

	public ByteArrayOutputStream findByKeyName(String keyName) throws IOException;
	public void uploadFile(String keyName, MultipartFile file) throws IOException;
	
}
