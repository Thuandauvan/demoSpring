package com.laptrinhjavaweb.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.laptrinhjavaweb.dao.GenericDAO;

public class AbstractDAO<T,V extends Serializable> implements GenericDAO<T,V> {

	@Autowired
	private SessionFactory sessionFactory;
	
	private final Class<T> clazz;

	// get the generic type at runtime
    @SuppressWarnings("unchecked")
	public AbstractDAO() {
        clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		Session session = null;
		List<T> list = null;
		try {
			session = sessionFactory.openSession();
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery("FROM " + clazz.getName());		
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}		
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(V o) {
		Session session = null;
		Transaction tran = null;
		T t = null;
		try {
			session = sessionFactory.openSession();
			tran = session.beginTransaction();	
			t = (T) session.get(clazz.getName(), o);		
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		} finally {
			session.close();
		}		
		
		return t;
	}

	@Override
	public T save(T t) {
		Session session = null;
		Transaction tran = null;	
		try {
			session = sessionFactory.openSession();
			tran = session.beginTransaction();
			session.save(t);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		} finally {
			session.close();
		}
		
		return t;
	}

	@Override
	public void delete(T t) {
		Session session = null;
		Transaction tran = null;
		try {
			session = sessionFactory.openSession();
			tran = session.beginTransaction();
			session.delete(t); 
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		} finally {
			session.close();
		}		
	}

	@Override
	public void update(T t) {
		Session session = null;
		Transaction tran = null;
		try {
			session = sessionFactory.openSession();
			tran = session.beginTransaction();
			session.update(t); 
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		} finally {
			session.close();
		}
	}
	
}
