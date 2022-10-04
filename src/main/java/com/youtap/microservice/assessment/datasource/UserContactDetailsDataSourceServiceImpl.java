package com.youtap.microservice.assessment.datasource;

import java.net.URI;
import java.net.URISyntaxException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.youtap.microservice.assessment.controller.entity.User;

@Service  
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)

public class UserContactDetailsDataSourceServiceImpl implements UserContactDetailsDataSourceService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public ResponseEntity<User[]> getContactsbyIDorUsername() throws URISyntaxException {
		String usersUrl = "https://jsonplaceholder.typicode.com/users";
		URI uri = new URI(usersUrl);
		ResponseEntity<User[]> result = restTemplate.getForEntity(uri, User[].class);
	return result;

	}
}
