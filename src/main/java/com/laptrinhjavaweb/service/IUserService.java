package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.User;
import com.laptrinhjavaweb.response.Response;

public interface IUserService {
	Response addNewUser(User user);
}
