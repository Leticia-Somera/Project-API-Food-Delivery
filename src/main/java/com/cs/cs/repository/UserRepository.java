package com.cs.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs.cs.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

	Users findByEmail(String email);

}	
