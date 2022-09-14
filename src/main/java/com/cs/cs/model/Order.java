package com.cs.cs.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String status; 
	
	private float total_price;
	
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date order_date;
	
	@ManyToOne//(fetch = FetchType.LAZY)	
	private Users user;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order") 
	private List<OrderProduct> orderProducts;
	
	public Order() {}

	public Order(String status, float total_price, Date order_date) {
		super();
		this.status = status;
		this.total_price = total_price;
		this.order_date = order_date;
	}

	public Order(String status, float total_price) {
		this.status = status;
		this.total_price = total_price;
	}

	public Order(long id, String status, float total_price) {
		this.id = id;
		this.status = status;
		this.total_price = total_price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}
	
	@Override
	public String toString() {
		return "Order [id = " + id + ", status = " + status + ", total_price = " + total_price + ", user = " + user + "]";
	}
	
}
