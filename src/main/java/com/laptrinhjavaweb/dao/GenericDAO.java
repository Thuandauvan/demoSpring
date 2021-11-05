package com.laptrinhjavaweb.dao;

import java.util.List;

public interface GenericDAO<T,V> {
    
	List<T> findAll();
	
	T findById(V o);
	
	T save(T t);
	
	void delete(T t);
	
	void update(T t);
}
