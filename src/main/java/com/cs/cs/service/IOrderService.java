package com.cs.cs.service;

import java.util.List;

import com.cs.cs.model.Order;

public interface IOrderService {
	
	Order create(Order order);
	
	Order update(Order order);
	
	Order findById(Long id);
	
	List<Order> findAll();
	
	void delete(Long id);

}
