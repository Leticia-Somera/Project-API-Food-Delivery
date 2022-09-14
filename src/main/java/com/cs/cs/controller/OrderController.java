package com.cs.cs.controller;

import java.net.URI;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.cs.cs.exception.ModelNotFoundException;
import com.cs.cs.model.Order;
import com.cs.cs.model.OrderProduct;
import com.cs.cs.model.Product;
import com.cs.cs.model.Users;
import com.cs.cs.service.OrderProductService;
import com.cs.cs.service.OrderService;
import com.cs.cs.service.ProductService;
import com.cs.cs.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;

@CrossOrigin
@RestController
public class OrderController {
	
	//Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderProductService orderProductService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(path = "/orders/{user_id}")
	public List<Order> showOrders(@PathVariable long user_id){
		return orderService.findAllByUserId(user_id);
	} 
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/order/{id}")
	public ResponseEntity<Order> showOrder(@PathVariable("id") long id) throws Exception{
		Order order = orderService.findById(id);
		if(order == null) {
			throw new ModelNotFoundException("The requested order does not exist."); 
		}
		
		return new ResponseEntity<>(order, HttpStatus.OK);	
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/order/{id}/detail")
	public CollectionModel<OrderProduct> orderDetail(@PathVariable("id") Long id){
		Order order = orderService.findById(id);
		if(order == null) {
			throw new ModelNotFoundException("The requested order does not exist."); 
		}
		
		List<OrderProduct> products = order.getOrderProducts();
		
		CollectionModel<OrderProduct> model = CollectionModel.of(products);
		
		return model;
		
	}
	
	
	@DeleteMapping(path = "/order/{id}")
	public void delete(@PathVariable("id") Long id) throws Exception {
		Order order = orderService.findById(id);
			if(order == null) {
				throw new ModelNotFoundException("The order you want to delete does not exist."); 
			}
			
			order.setStatus("CANCELED");
			orderService.update(order);
			return; 
	}
	
	
	@PutMapping(path = "/order/{id}")
	public void update(@PathVariable("id") Long id) throws Exception {
		Order orderUpdated = orderService.findById(id);
		
		if(orderUpdated == null) {
			throw new ModelNotFoundException("The order you want to update does not exist."); 
		}
		
		orderUpdated.setStatus("COMPLETED");
		orderService.update(orderUpdated);
		return;
	}		
	
	
	@PostMapping(path = "/order")
	public ResponseEntity<Object> create(@RequestBody JsonNode newInfo) {
    
    long idCustomer = newInfo.get("user").get("id").asLong();
    Users user = userService.findById(idCustomer);
    
    if(user == null) {
        throw new ModelNotFoundException(
                "The user requested does not exist");
    }
    
    float total_price = newInfo.get("total_price").floatValue();
    Order order = new Order("CREATED", total_price, new Date());
    order.setUser(user);
    
    Order createOrder = orderService.create(order);
    
    Iterator<JsonNode> meals = newInfo.get("orderProducts").elements();
    
    while(meals.hasNext()) {
        JsonNode currentMeal = meals.next();
        Product product = productService.findById(currentMeal.get("product").get("id").asLong());
        if(product == null) {
            throw new ModelNotFoundException(
                    "The meal required does not exist");
        }
        OrderProduct meal = new OrderProduct(currentMeal.get("num_products").asInt());
        meal.setProduct(product);
        meal.setOrder(createOrder);
        OrderProduct itemSaved = orderProductService.create(meal);
    }
    
   URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(createOrder.getId()).toUri();
			

	return ResponseEntity.created(location).build();
	
	
	}
}
	
	
	
	
