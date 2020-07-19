package com.fl.init.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fl.init.rest.dao.ProductDAO;
import com.fl.init.rest.entity.Product;

/**
 * API Rest funcional, a modo de introducción.
 * 
 * @author Francisco Larrocca
 *
 */

@RestController
@RequestMapping(value="/products")
public class RESTController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@GetMapping(value="/all") // localhost:8080/products/all
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = productDAO.findAll();
		return ResponseEntity.ok(products);
	}
	
	@RequestMapping(value="/{productId}") // localhost:8080/products/{id}
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId){
		Optional<Product> product = productDAO.findById(productId);

		if(!product.isPresent()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(product.get());
		}
	}
	
	@PostMapping //Crear
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product newProduct = productDAO.save(product);
		return ResponseEntity.ok(newProduct);
	}
	
	@DeleteMapping(value="/{productId}") //Borrar
	public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId) {
		productDAO.deleteById(productId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping //Actualizar
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		Optional<Product> optionalProduct = productDAO.findById(product.getId());

		if(!optionalProduct.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			Product updateProduct = optionalProduct.get();
			updateProduct.setName(product.getName());
			productDAO.save(updateProduct);
			return ResponseEntity.ok(updateProduct);
		}
	}
	
}
