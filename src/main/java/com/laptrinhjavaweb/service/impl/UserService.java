package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.model.Cart;
import com.laptrinhjavaweb.model.User;
import com.laptrinhjavaweb.response.HTTPStatus;
import com.laptrinhjavaweb.response.Response;
import com.laptrinhjavaweb.service.IUserService;

@Service
public class UserService extends AbstractService implements IUserService {

	@Override
	public Response addNewUser(User user) {
		Session session = null;
		Transaction tran = null;	
		try {
			session = sessionFactory.openSession();
			
			// check if this user exist?
			String hql = "FROM User WHERE userName =: userName AND email =: email";
			Query<User> query = session.createQuery(hql, User.class);
			query.setParameter("userName", user.getUserName());
			query.setParameter("email", user.getEmail());
			List<User> list = query.list();
			// If user doesn't exist
			if(list.size() == 0) {
				tran = session.beginTransaction();
				Cart cart = new Cart();			
				// set date for user and cart
				user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
				user.setModifiedDate(user.getCreatedDate());
				cart.setCreatedDate(user.getCreatedDate());
				cart.setModifiedDate(user.getCreatedDate());
				// save user in DB and generate cart for user
				userDAO.save(user);
				cartDAO.save(cart);
				@SuppressWarnings("rawtypes")
				Query query_update = session.createQuery("UPDATE User SET status = 1, cart_id =: cart_id WHERE id =: id");
				query_update.setParameter("cart_id", cart.getId());
				query_update.setParameter("id", user.getId());
				query_update.executeUpdate();
				tran.commit();				
			} else {
				response.setCode(HTTPStatus.Already_Exists.getCode());
				response.setMessage(HTTPStatus.Already_Exists.getMessage());
			}			
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(HTTPStatus.SERVER_ERROR.getCode());
			response.setMessage(HTTPStatus.SERVER_ERROR.getMessage());
			tran.rollback();
		}
		
		return response;
	}

}
