package com.cs.cs.service;

import java.util.List;
import com.cs.cs.model.OrderProduct;

public interface IOrderProductService {

	public OrderProduct create(OrderProduct orderProduct);

	public OrderProduct update(OrderProduct orderProduct);
	
	public OrderProduct findById(Long id);
	
	public List<OrderProduct> findAll();
	
	public void delete(Long id);

	public List<OrderProduct> findAllById(Long id);

}
