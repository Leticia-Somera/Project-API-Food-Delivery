package com.cs.cs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.cs.exception.ModelNotFoundException;
import com.cs.cs.model.Order;
import com.cs.cs.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired 
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Order> create(@RequestBody Order order) {
		return new ResponseEntity<>(orderService.create(order), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Object> update(@RequestBody Order order) {
		orderService.update(order);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable("id") Long idOrder) throws Exception{
		Order order = orderService.findById(idOrder);
		if(order == null) {
			throw new ModelNotFoundException("The requested order does not exist."); 
		}
		return new ResponseEntity<>(order, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Long idOrder) throws Exception{
		Order order = orderService.findById(idOrder);
		if(order == null) {
			throw new ModelNotFoundException("The order you want to delete does not exist."); 
		}
		orderService.delete(idOrder);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
