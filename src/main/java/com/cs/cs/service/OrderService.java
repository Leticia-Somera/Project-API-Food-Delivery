package com.cs.cs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.cs.model.Order;
import com.cs.cs.repository.OrderRepository;

@Service
public class OrderService implements IOrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order create(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order update(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order findById(Long id) {
		Optional<Order> orderOptional = orderRepository.findById(id);
		return orderOptional.orElse(null);
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		orderRepository.deleteById(id);			
	}

}
