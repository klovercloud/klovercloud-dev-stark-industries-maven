package com.starkindustries;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@SpringBootApplication
@EnableCaching

@RestController
public class Application{
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@GetMapping("api/v1/health")
	public String getHealth() {
		
		return "Hello from stark industries!";
	}
}


