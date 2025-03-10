package com.yaksha.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yaksha.assignment.entity.Order;
import com.yaksha.assignment.entity.Product;
import com.yaksha.assignment.repository.CustomProductRepository; // Import CustomProductRepository
import com.yaksha.assignment.repository.OrderRepository;
import com.yaksha.assignment.repository.ProductRepository;

@Service
public class TransactionService {

	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;
	private final CustomProductRepository customProductRepository; // Inject CustomProductRepository

	@Autowired
	public TransactionService(OrderRepository orderRepository, ProductRepository productRepository,
			CustomProductRepository customProductRepository) {
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
		this.customProductRepository = customProductRepository; // Initialize CustomProductRepository
	}

	@Transactional
	public void placeOrder(Order order) {
		// Save the order
		orderRepository.save(order);

		// Fetch the product and update its stock using CustomProductRepository
		Product product = productRepository.findById(order.getProductId())
				.orElseThrow(() -> new RuntimeException("Product not found"));

		// Use the custom repository method to update stock
		customProductRepository.updateProductStock(product.getId(), order.getQuantity());

		// Save the updated product
		productRepository.save(product);
	}
}
