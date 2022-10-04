package com.youtap.microservice.assessment.datasource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtap.microservice.assessment.controller.entity.User;

@Service
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
