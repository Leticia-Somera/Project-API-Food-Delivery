package com.cs.cs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cs.cs.model.OrderProduct;
import com.cs.cs.repository.OrderProductRepository;

@Service
public class OrderProductService implements IOrderProductService{

	@Autowired
	private OrderProductRepository orderProductRepository;
	
	@Override
	public OrderProduct create(OrderProduct order) {
		return orderProductRepository.save(order);
	}

	@Override
	public OrderProduct update(OrderProduct order) {
		return orderProductRepository.save(order);
	}

	@Override
	public OrderProduct findById(Long id) {
		Optional<OrderProduct> orderOptional = orderProductRepository.findById(id);
		return orderOptional.orElse(null);
	}

	@Override
	public List<OrderProduct> findAll() {
		return orderProductRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		orderProductRepository.deleteById(id);			
	}

	@Override
	public List<OrderProduct> findAllById(Long id) {
		return orderProductRepository.findAllById(id);
	}


}
