package com.fl.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * API Rest funcional, a modo de introducción.
 * 
 * @author Francisco Larrocca
 *
 */

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int produdctId;
	
	
	@Column(name = "product_name")
	private String productName;
	
	private int quantity;
	
	private double price;
	
	public Product() {
		super();
	}

	public int getId() {
		return produdctId;
	}

	public void setId(int id) {
		this.produdctId = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + produdctId + ", productName=" + productName + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}
}
