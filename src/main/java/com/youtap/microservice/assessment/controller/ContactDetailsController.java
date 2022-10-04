package com.youtap.microservice.assessment.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.youtap.microservice.assessment.controller.dto.UserDTO;
import com.youtap.microservice.assessment.controller.entity.User;

@RestController
public class ContactDetailsController {

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "/getusercontacts", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> getContactsbyIDorUsername(@PathVariable String ID, @RequestParam String username)throws URISyntaxException {

		UserDTO userDTO = new UserDTO();
		User user = modelMapper.map(userDTO, User.class);

		RestTemplate restTemplate = new RestTemplate();
		String usersUrl = "https://jsonplaceholder.typicode.com/users";
		URI uri = new URI(usersUrl);
		ResponseEntity<User> result = restTemplate.getForEntity(uri, User.class);

		return  result;
	}

}
