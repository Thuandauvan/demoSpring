package com.laptrinhjavaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.laptrinhjavaweb.model.Product;
import com.laptrinhjavaweb.response.Response;
import com.laptrinhjavaweb.service.IProductService;

@RestController
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@GetMapping("/product")
	public Response findAll(){
		return productService.findAll();
	}
	
	@PostMapping("/product")
	public Response saveProduct(@RequestPart Product product, @RequestPart MultipartFile img){
		return productService.save(product,img);
	}
	
	@DeleteMapping("/product")
	public Response deleteProductByIds(@RequestBody Long[] ids){
		return productService.delete(ids);
	}
	
	@PutMapping("/product")
	public Response updateProduct(@RequestBody Product product){
		return productService.update(product);
	}
	
}
