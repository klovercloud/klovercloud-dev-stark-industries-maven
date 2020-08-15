package com.starkindustries;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
 
@SpringBootApplication
@EnableCaching
public class Application{
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}