package com.fl.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fl.rest.dto.OrderResponse;
import com.fl.rest.entity.Customer;

/**
 * API Rest funcional, a modo de introducción.
 * 
 * @author Francisco Larrocca
 *
 */

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {
	
	@Query("SELECT new com.fl.rest.dto.OrderResponse(c.name, p.productName) FROM Customer c JOIN c.products p")
	public List<OrderResponse> getJoinInfo();

}
