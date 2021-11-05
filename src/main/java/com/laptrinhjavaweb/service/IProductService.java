package com.laptrinhjavaweb.service;

import org.springframework.web.multipart.MultipartFile;

import com.laptrinhjavaweb.model.Product;
import com.laptrinhjavaweb.response.Response;

public interface IProductService {
	Response findAll();
	Response save(Product product, MultipartFile img);
	Response update(Product product);
	Response delete(Long[] ids);
}
