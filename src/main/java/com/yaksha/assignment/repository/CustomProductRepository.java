package com.yaksha.assignment.repository;

import org.springframework.stereotype.Repository;

import com.yaksha.assignment.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CustomProductRepository {

	private EntityManager entityManager;

	public void updateProductStock(Long productId, Integer quantitySold) {
		
			// Decrease stock based on quantity sold
		
	}
}
