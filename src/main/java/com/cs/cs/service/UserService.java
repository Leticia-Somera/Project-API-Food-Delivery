package com.cs.cs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cs.cs.model.Users;
import com.cs.cs.repository.UserRepository;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Users create(Users user) {
		return userRepository.save(user);
	}

	@Override
	public Users findById(Long id) {
		Optional<Users> userOptional = userRepository.findById(id);
		return userOptional.orElse(null);
	}

	@Override
	public List<Users> findAll() {
		return userRepository.findAll();
	}
/*
	@Override
	public void delete(long id) {
		return;		
	}*/

	public Users findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
