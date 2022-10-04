package com.youtap.microservice.assessment.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youtap.microservice.assessment.controller.entity.User;
import com.youtap.microservice.assessment.datasource.UserContactDetailsDataSourceService;

@RestController
public class ContactDetailsController implements UserContactDetailsDataSourceService {

	@Autowired
	UserContactDetailsDataSourceService userContactDataSourceService;

	@Override
	@GetMapping(value = "/getusercontacts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User[]> getContactsbyIDorUsername()throws URISyntaxException {
		ResponseEntity<User[]> cachedContactlist = userContactDataSourceService.getContactsbyIDorUsername();
		return cachedContactlist; 
	}

}
