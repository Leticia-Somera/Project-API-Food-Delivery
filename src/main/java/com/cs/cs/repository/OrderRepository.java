package com.cs.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.cs.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
