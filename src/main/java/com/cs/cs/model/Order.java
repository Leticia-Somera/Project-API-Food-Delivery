package com.cs.cs.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private long id_order;
	
	@OneToOne
	@JoinColumn(name = "id_user", referencedColumnName = "id_user")
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Product> products = new ArrayList<Product>();
	
	@Column(name = "order_date")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date order_date;
	
	@Column(name = "status", nullable = false, length = 9)
	private String status;
	
	@Column(name = "total_price", nullable = false)
	private float total_price;

	public long getId_order() {
		return id_order;
	}

	public void setId_order(long id_order) {
		this.id_order = id_order;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	
}
