package com.cs.cs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;*/
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_order", referencedColumnName = "id_order")	
	private Order order;*/
	
	@Column(name = "name", nullable = false, length = 30)
	private String name;
	
	@Column(name = "price", nullable = false)
	private float price;
	
	@Column(name = "description", nullable = false, length = 50)
	private String description;
	
	@Column(name = "image", nullable = false, length = 200)
	private String image;

	protected Product() {}
	public Product(String name, float price, String description, String image) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Product [id = " + id + ", name=" + name + ", price=" + price + ", description = " + description + "]";
	}
	
}
