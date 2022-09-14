package com.cs.cs.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "email", nullable = false, length = 30)
	private String email;
	
	@Column(name = "password", nullable = false, length = 8)
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@JsonIgnore
	private List<Order> order;
	
	protected Users() {}
	public Users(String email, String password) {
		super();		
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	
	@Override
	public String toString() {
		return "User [id = " + id + ", email = "
				+ email + "]";
	}
	
}
