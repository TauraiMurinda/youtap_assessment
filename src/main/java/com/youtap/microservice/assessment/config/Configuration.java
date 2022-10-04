package com.youtap.microservice.assessment.config;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public RestTemplate restTemplate() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}

}
