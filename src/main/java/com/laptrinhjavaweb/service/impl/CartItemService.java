package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.model.CartItem;
import com.laptrinhjavaweb.model.Product;
import com.laptrinhjavaweb.response.HTTPStatus;
import com.laptrinhjavaweb.response.Response;
import com.laptrinhjavaweb.service.ICartItemService;

@Service
public class CartItemService extends AbstractService implements ICartItemService {
	
	@Override
	public Response getListItem() {
		try {
			response.setData(cartItemDAO.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage(HTTPStatus.SERVER_ERROR.getMessage());
			response.setCode(HTTPStatus.SERVER_ERROR.getCode());
		}
		return response;
	}
	
	@Override
	public Response addToCartItem(Long id) {
		Session session = null;
		Transaction tran = null;
		try {
			session = sessionFactory.openSession();
			tran = session.beginTransaction();
			Query<CartItem> query = session.createQuery("FROM CartItem WHERE product_id =: id", CartItem.class);
			query.setParameter("id", id);
			List<CartItem> list = query.list();
			CartItem cartItem = new CartItem();
			if(list.size() != 0) {
				cartItem.setQuantity(list.get(0).getQuantity() + 1);
				session.update(cartItem);
			} else {
				Product product = productDAO.findById(id);
				cartItem.setProduct(product);
				cartItem.setQuantity(1);
				session.save(cartItem);
			}
			tran.commit();
			} catch (Exception e) {
				e.printStackTrace();
				response.setCode(HTTPStatus.DATA_NOT_FOUND.getCode());
				response.setMessage(HTTPStatus.DATA_NOT_FOUND.getMessage());
				tran.rollback();
			} finally {
				session.close();
			}
		return response;
	}
	
	@Override
	public Response updateCartItem(Long id, Integer quantity) {
		try {
			CartItem cartItem = cartItemDAO.findById(id);
			cartItem.setQuantity(quantity);
			cartItemDAO.update(cartItem);
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(HTTPStatus.SERVER_ERROR.getCode());
			response.setMessage(HTTPStatus.SERVER_ERROR.getMessage());
		}
		return response;
	}

	@Override
	public Response deleteCartItem(Long[] ids) {
		try {
			for(Long id : ids) {
				CartItem cartItem = cartItemDAO.findById(id);
				cartItemDAO.delete(cartItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(HTTPStatus.SERVER_ERROR.getCode());
			response.setMessage(HTTPStatus.SERVER_ERROR.getMessage());
		}
		return response;
	}

}
