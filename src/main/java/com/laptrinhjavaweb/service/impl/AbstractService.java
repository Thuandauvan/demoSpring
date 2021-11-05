package com.laptrinhjavaweb.service.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.laptrinhjavaweb.dao.ICartDAO;
import com.laptrinhjavaweb.dao.ICartItemDAO;
import com.laptrinhjavaweb.dao.IProductDAO;
import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.response.Response;
import com.laptrinhjavaweb.service.GenericService;

public class AbstractService implements GenericService {
	
	@Autowired 
	protected SessionFactory sessionFactory;
	
	@Autowired
	protected Response response;
	
	@Lazy
	@Autowired
	protected ICartItemDAO cartItemDAO;
	
	@Lazy
	@Autowired
	protected IProductDAO productDAO;
	
	@Lazy
	@Autowired
	protected IUserDAO userDAO;
	
	@Lazy
	@Autowired
	protected ICartDAO cartDAO;
}
