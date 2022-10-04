package com.youtap.microservice.assessment.controller.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class NoMatchedUserContactDetailsException  extends ResponseStatusException {

	private static final long serialVersionUID = -8863681135925713141L;
	

	 public NoMatchedUserContactDetailsException(String message) {
		    super(HttpStatus.NOT_FOUND, message);
	}

	@Override
	  public HttpHeaders getResponseHeaders() {
		return null;
	      // return response headers
	  }

}
