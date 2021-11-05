package com.laptrinhjavaweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.dao.ICartItemDAO;
import com.laptrinhjavaweb.model.CartItem;

@Repository
public class CartItemDAO extends AbstractDAO<CartItem, Long> implements ICartItemDAO {

}
