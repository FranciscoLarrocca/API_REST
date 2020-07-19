package com.fl.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fl.rest.dao.CustomerDAO;
import com.fl.rest.dto.OrderRequest;
import com.fl.rest.dto.OrderResponse;
import com.fl.rest.entity.Customer;

/**
 * API Rest funcional, a modo de introducción.
 * 
 * @author Francisco Larrocca
 *
 */


@RestController
public class RESTController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@GetMapping("/findAllOrders")
	public List<Customer> findAllOrders(){
		return customerDAO.findAll();
	}
	
	@PostMapping("/placeOrder")
	public Customer placeOrder(@RequestBody OrderRequest request) {
		return customerDAO.save(request.getCustomer());
	}
	
	@GetMapping("/getInfo")
	public List<OrderResponse> getJoinInfo(){
		return customerDAO.getJoinInfo();
	}
	
	//Eliminar orden(cliente y productos asociados al mismo):
	@DeleteMapping("/deleteOrder/{id}")
	public void deleteOrder(@PathVariable(name = "id") int id) {
		customerDAO.deleteById(id);
	}
	
}
