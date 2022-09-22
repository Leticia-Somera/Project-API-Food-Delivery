package com.cs.cs.jwt;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cs.cs.model.Users;
import com.cs.cs.service.UserService;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService user;
	/*
	@Autowired
	private PasswordEncoder bcryptEncoder;*/

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users customer = user.findByEmail(username);
		
		if (customer == null) {
			throw new UsernameNotFoundException("User " + username + " was not found"	);
		}
		return new org.springframework.security.core.userdetails.User(customer.getEmail(), new BCryptPasswordEncoder().encode(customer.getPassword()), 
				new ArrayList<>());		
		
	}
}