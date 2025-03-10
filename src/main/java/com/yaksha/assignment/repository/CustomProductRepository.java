package com.yaksha.assignment.repository;

import org.springframework.stereotype.Repository;

import com.yaksha.assignment.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CustomProductRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void updateProductStock(Long productId, Integer quantitySold) {
		Product product = entityManager.find(Product.class, productId);
		if (product != null) {
			// Decrease stock based on quantity sold
			product.setStock(product.getStock() - quantitySold);
		}
	}
}
