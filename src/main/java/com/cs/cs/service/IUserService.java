package com.cs.cs.service;

import java.util.List;

import com.cs.cs.model.User;

public interface IUserService {
	
	User create(User user);
	
	User findById(Long id);
	
	List<User> findAll();

	void delete(Long id);
}
