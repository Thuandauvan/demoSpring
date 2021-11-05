package com.laptrinhjavaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.response.Response;
import com.laptrinhjavaweb.service.ICartItemService;

@RestController
public class CartItemController {
	
	@Autowired 
	private ICartItemService cartItemService;
	
	@GetMapping("/cartItem")
	public Response listCartItem() {
		return cartItemService.getListItem();
	}
	
	@PostMapping("/cartItem/{id}")
	public Response addToCartItem(@PathVariable Long id){
		return cartItemService.addToCartItem(id);
	}
	
	@PutMapping("/cartItem/{id}/{quantity}")
	public Response updateItem(@PathVariable Long id, @PathVariable Integer quantity){
		return cartItemService.updateCartItem(id, quantity);
	}
	
	@DeleteMapping("/cartItem")
	public Response deleteItem(@RequestBody Long[] ids){
		return cartItemService.deleteCartItem(ids);
	}
	
}