package com.laptrinhjavaweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.dao.ICartDAO;
import com.laptrinhjavaweb.model.Cart;

@Repository
public class CartDAO extends AbstractDAO<Cart, Long> implements ICartDAO {

}
