package com.laptrinhjavaweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.dao.IProductDAO;
import com.laptrinhjavaweb.model.Product;

@Repository
public class ProductDAO extends AbstractDAO<Product, Long> implements IProductDAO{
	
}
