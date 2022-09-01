package com.cs.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.cs.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
