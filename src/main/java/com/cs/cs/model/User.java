package com.cs.cs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private long id_user;
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "order_id", referencedColumnName = "idOrder")
   // private Order order;
	
	@Column(name = "username", nullable = false, length = 30)
	private String username;
	
	@Column(name = "email", nullable = false, length = 30)
	private String email;
	
	@Column(name = "password", nullable = false, length = 8)
	private String password;

	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
