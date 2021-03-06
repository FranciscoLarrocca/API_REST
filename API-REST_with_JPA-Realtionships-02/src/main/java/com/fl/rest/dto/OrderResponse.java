package com.fl.rest.dto;

/**
 * API Rest funcional, a modo de introducción.
 * 
 * @author Francisco Larrocca
 *
 */

public class OrderResponse {
	private String name;
	private String productName;
	
	public OrderResponse(String name, String productName) {
		this.name = name;
		this.productName = productName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "OrderResponse [name=" + name + ", productName=" + productName + "]";
	}
	
	
}
