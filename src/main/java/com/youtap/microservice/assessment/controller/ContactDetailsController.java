package com.youtap.microservice.assessment.controller;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<User> getContactDetailsByIDorUsername(@RequestParam(value="id",required=false) Integer  id, @RequestParam(value="username", required=false) String  username) throws URISyntaxException {
		
		LOG.info("ABOUT TO CALL CONTACTSLIST BACK END");
		ResponseEntity<User[]> cachedContactlist = userContactDataSourceService.getContactsbyIDorUsername();
		LOG.info("SEARCHING CONTACT DETAILS FOR PARTICULAR USER");
		
		User  userContactsMatched= filterContacts(id, username, cachedContactlist);
		ResponseEntity<User>userContactsMatchedResponseEntity = new ResponseEntity<>(userContactsMatched,HttpStatus.OK);
		return userContactsMatchedResponseEntity; 
	}


	private  User filterContacts(Integer id, String username, ResponseEntity<User[]> cachedContactlist) {
		User[] users = cachedContactlist.getBody().clone();
		
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		
		User use = new User();
		user.setId(id);
		user.setUsername(username);

		LOG.info("" + use.equals(user));
		
		Predicate<User> userpredicate = other -> {return user.equals(other);};
		 List<User> user1 = Arrays.stream(users).filter(userpredicate).collect(Collectors.toList());
		 
		
		
		LOG.info("*******************************************" + user1.size());
		LOG.info("" + use.equals(user));

		LOG.info("" + user1.get(0));
		
		LOG.info("*******************************************");
		return user1.get(0);
	}

}
