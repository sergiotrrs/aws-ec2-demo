package com.aws.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("api/v1/greeting")
public class GreetingController {
	
	private int numberOfRequest;
	
	@GetMapping
	String sendGreeting() {
		return String.format("<h1>Hello, this is request number %d</h1>", ++numberOfRequest);
	}
	

}
