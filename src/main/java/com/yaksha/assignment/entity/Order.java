package com.yaksha.assignment.entity;

public class Order {

	private Long id;

	private Long productId;
	private Integer quantity;

	// Constructors
	public Order() {
	}

	public Order(Long productId, Integer quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
