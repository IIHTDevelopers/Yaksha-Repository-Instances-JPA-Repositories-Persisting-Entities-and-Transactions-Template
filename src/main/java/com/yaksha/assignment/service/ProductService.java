package com.yaksha.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaksha.assignment.entity.Product;
import com.yaksha.assignment.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// Get all products
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	// Create or update a product
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	// Delete a product by ID
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
