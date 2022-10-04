package com.youtap.microservice.assessment.datasource;

import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;

import com.youtap.microservice.assessment.controller.entity.User;


public interface UserContactDetailsDataSourceService {

	ResponseEntity<User[]> getContactsbyIDorUsername() throws URISyntaxException;

}