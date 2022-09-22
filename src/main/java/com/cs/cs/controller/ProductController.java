package com.cs.cs.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
/*import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import com.cs.cs.exception.ModelNotFoundException;
import com.cs.cs.model.Product;
import com.cs.cs.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/products")
	public ResponseEntity<List<Product>> findAll() {		
		return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
	}
	/*
	@PostMapping
	public ResponseEntity<Product> create(@RequestBody Product product) {
		return new ResponseEntity<>(productService.create(product), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable("id") Long idProduct) throws Exception{
		Product product = productService.findById(idProduct);
		if(product == null) {
			throw new ModelNotFoundException("The requested product does not exist."); 
		}
		return new ResponseEntity<>(productService.findById(idProduct), HttpStatus.OK);
	}*/
	
}
