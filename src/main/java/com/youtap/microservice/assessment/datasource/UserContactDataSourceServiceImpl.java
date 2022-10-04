package com.youtap.microservice.assessment.datasource;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.youtap.microservice.assessment.controller.entity.User;


@Service
public class  UserContactDataSourceServiceImpl implements UserContactDataSourceService {
	
	@Override
	public ResponseEntity<User[]> getContactsbyIDorUsername() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		String usersUrl = "https://jsonplaceholder.typicode.com/users";
		URI uri = new URI(usersUrl);
		ResponseEntity<User[]> result = restTemplate.getForEntity(uri, User[].class);
		return result;
	}

}
