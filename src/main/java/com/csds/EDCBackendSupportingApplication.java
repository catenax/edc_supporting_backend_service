package com.csds;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.csds.service.StorageProperties;
import com.csds.service.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class EDCBackendSupportingApplication {

	public static void main(String[] args) {
	 SpringApplication.run(EDCBackendSupportingApplication.class, args);
	}

	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
