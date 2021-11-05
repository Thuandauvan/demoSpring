package com.laptrinhjavaweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.model.User;

@Repository
public class UserDAO extends AbstractDAO<User, Long> implements IUserDAO{

}
