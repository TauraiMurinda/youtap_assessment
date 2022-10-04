package com.youtap.microservice.assessment.controller;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtap.microservice.assessment.Application;
import com.youtap.microservice.assessment.controller.entity.User;
import com.youtap.microservice.assessment.datasource.UserContactDetailsDataSourceService;

@RestController
public class ContactDetailsController {
	
	   private static final Logger LOG = LoggerFactory.getLogger(ContactDetailsController.class);


	@Autowired
	UserContactDetailsDataSourceService userContactDataSourceService;

	
	@GetMapping(value = "/getusercontacts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User[]> getContactDetailsByIDorUsername(@RequestParam(value="id",required=true) String  id, @RequestParam(value="username", required=false) String  username) throws URISyntaxException {
		
		LOG.info("ABOUT TO CALL CONTACTSLIST BACK END");
		ResponseEntity<User[]> cachedContactlist = userContactDataSourceService.getContactsbyIDorUsername();
		
		ObjectMapper mapper = new ObjectMapper();

		
		LOG.info("SEARCHING CONTACT DETAILS FOR PARTICULAR USER");
		
		LOG.info("id   :" +id +"\n" +"username    :"+username);

		Predicate<User> Userpredicate = user -> {return id.equalsIgnoreCase(String.valueOf(user.getId())) || username.equalsIgnoreCase(user.getUsername());};
		List<User> userlist = Arrays.stream(cachedContactlist.getBody()).filter(Userpredicate).collect(Collectors.toList());
		
		LOG.info("*******************************************");
		LOG.info("" + userlist.size());
		
		LOG.info("*******************************************");

		return cachedContactlist; 
	}

}
