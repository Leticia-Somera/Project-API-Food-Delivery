package com.cs.cs.service;

import java.util.List;

import com.cs.cs.model.Users;

public interface IUserService {
	
	Users create(Users user);
	
	Users findByEmail(String email);
	
	List<Users> findAll();

	Users findById(Long id);

	//void delete(long id);
}
