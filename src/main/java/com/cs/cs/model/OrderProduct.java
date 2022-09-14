package com.cs.cs.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "order_products")
public class OrderProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne//(fetch = FetchType.LAZY)
	private Product product;
	
	private int num_products;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Order order;
	
	public OrderProduct() {}

	public OrderProduct(int num_products) {
		super();
		this.num_products = num_products;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNum_products() {
		return num_products;
	}

	public void setNum_products(int num_products) {
		this.num_products = num_products;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderProduct [id =" + id + num_products + "]";
	}
	
}
