package com.fl.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fl.rest.entity.Product;

/**
 * API Rest funcional, a modo de introducción.
 * 
 * @author Francisco Larrocca
 *
 */

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

}
