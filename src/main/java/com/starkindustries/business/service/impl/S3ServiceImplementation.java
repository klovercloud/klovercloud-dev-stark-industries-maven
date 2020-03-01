package com.starkindustries.business.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.starkindustries.business.service.S3Service;

@Service
public class S3ServiceImplementation implements S3Service{
	
private Logger logger = LoggerFactory.getLogger(S3ServiceImplementation.class);
	
	@Autowired
	private AmazonS3 s3client;
 
	@Value("${s3.bucket}")
	private String bucketName;

	@Override
	public ByteArrayOutputStream findByKeyName(String keyName) throws IOException {
		try {
            S3Object s3object = s3client.getObject(new GetObjectRequest(bucketName, keyName));
            
            InputStream is = s3object.getObjectContent();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len;
            byte[] buffer = new byte[4096];
            while ((len = is.read(buffer, 0, buffer.length)) != -1) {
                baos.write(buffer, 0, len);
            }
            
            return baos;
		} catch (IOException ioe) {
			logger.error("IOException: " + ioe.getMessage());
			throw ioe;
        } catch (AmazonServiceException ase) {
        	logger.info("sCaught an AmazonServiceException from GET requests, rejected reasons:");
			logger.info("Error Message:    " + ase.getMessage());
			logger.info("HTTP Status Code: " + ase.getStatusCode());
			logger.info("AWS Error Code:   " + ase.getErrorCode());
			logger.info("Error Type:       " + ase.getErrorType());
			logger.info("Request ID:       " + ase.getRequestId());
			throw ase;
        } catch (AmazonClientException ace) {
        	logger.info("Caught an AmazonClientException: ");
            logger.info("Error Message: " + ace.getMessage());
            throw ace;
        }
		
	}
 
	@Override
	public void uploadFile(String keyName, MultipartFile file) throws IOException {
		try {
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(file.getSize());
			s3client.putObject(bucketName, keyName, file.getInputStream(), metadata);
		} catch(IOException ioe) {
			logger.error("IOException: " + ioe.getMessage());
			throw ioe;
		} catch (AmazonServiceException ase) {
			logger.info("Caught an AmazonServiceException from PUT requests, rejected reasons:");
			logger.info("Error Message:    " + ase.getMessage());
			logger.info("HTTP Status Code: " + ase.getStatusCode());
			logger.info("AWS Error Code:   " + ase.getErrorCode());
			logger.info("Error Type:       " + ase.getErrorType());
			logger.info("Request ID:       " + ase.getRequestId());
			throw ase;
        } catch (AmazonClientException ace) {
            logger.info("Caught an AmazonClientException: ");
            logger.info("Error Message: " + ace.getMessage());
            throw ace;
        }
	}

}
