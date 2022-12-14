package com.cs.cs.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cs.cs.exception.ModelNotFoundException;
import com.cs.cs.model.Users;
import com.cs.cs.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
	
	@Autowired 
	private UserService userService;

	
	@PostMapping(path = "/user/id")
	public long getCustomerID(@RequestBody JsonNode payload) {
		System.out.println("Email: " + payload.toPrettyString());
		String email = payload.get("username").toString().replace("\"", "");
		
		Users user = userService.findByEmail(email);
		if(user == null)
			throw new ModelNotFoundException("The User is not registered. Please contact to the admin.");
		return user.getId();
	}
	

	/*@GetMapping
	public ResponseEntity<List<Users>> findAll(){
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}*/
		/*
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") Long idUser) throws Exception{
		User user = userService.findById(idUser);
		if(user == null) {
			throw new ModelNotFoundException("The requested user does not exist."); 
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Long idUser) throws Exception{
		User user = userService.findById(idUser);
		if(user == null) {
			throw new ModelNotFoundException("The user you want to delete does not exist."); 
		}
		userService.delete(idUser);
		return new ResponseEntity<>(HttpStatus.OK);
	}*/

}
