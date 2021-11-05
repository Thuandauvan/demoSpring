package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.response.Response;

public interface ICartItemService {
	Response getListItem();
	Response addToCartItem(Long id);
	Response updateCartItem(Long id, Integer quantity);
	Response deleteCartItem(Long[] ids);
}
