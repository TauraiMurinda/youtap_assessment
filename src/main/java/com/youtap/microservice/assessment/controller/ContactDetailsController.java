package com.youtap.microservice.assessment.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youtap.microservice.assessment.controller.entity.User;
import com.youtap.microservice.assessment.datasource.UserContactDataSourceService;

@RestController
public class ContactDetailsController implements UserContactDataSourceService {

	@Autowired
	UserContactDataSourceService userContactDataSourceService;

	@Override
	@GetMapping(value = "/getusercontacts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User[]> getContactsbyIDorUsername()throws URISyntaxException {
		ResponseEntity<User[]> cachedContactlist = userContactDataSourceService.getContactsbyIDorUsername();
		return cachedContactlist; 
	}

}
