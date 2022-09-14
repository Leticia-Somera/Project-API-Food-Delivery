package com.cs.cs.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cs.cs.model.OrderProduct;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long>{

	List<OrderProduct> findAllById(Long id);
}
