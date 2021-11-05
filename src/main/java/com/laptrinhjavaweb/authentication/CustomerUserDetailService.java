package com.laptrinhjavaweb.authentication;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.model.User;

@Service
public class CustomerUserDetailService implements UserDetailsService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Session session = null;
		List<User> list = null;
		try {
			session = sessionFactory.openSession();
			String hql = "FROM User u JOIN FETCH u.roles WHERE u.userName =: username AND u.status = 1";
			Query<User> query = session.createQuery(hql, User.class); 
			query.setParameter("username", username);
			list = query.list();
			
			// If the user is exist as USER
			if(list.size() > 0) {
				User user = list.get(0);
				List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
			    GrantedAuthority authority = new SimpleGrantedAuthority("USER");
			    grantList.add(authority);
				
				UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, user.getPassword(), grantList);
			    
				return userDetails;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;
	}

}
