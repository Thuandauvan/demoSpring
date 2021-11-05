package com.laptrinhjavaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.model.User;
import com.laptrinhjavaweb.response.Response;
import com.laptrinhjavaweb.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;
	
	@PostMapping(value = "/signup")
	public Response addNewUser(@RequestBody User user) {
		return userService.addNewUser(user);
	}
}
