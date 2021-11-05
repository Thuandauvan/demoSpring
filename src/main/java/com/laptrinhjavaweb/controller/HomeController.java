package com.laptrinhjavaweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.response.Response;

@RestController
public class HomeController {
	
	// Developing a RESTful service based on Spring (Spring boot)
	// Three- tier architecture vs MVC pattern
	
	@GetMapping("/login")
	public Response checkLogin(){
		return new Response();
	}

}
