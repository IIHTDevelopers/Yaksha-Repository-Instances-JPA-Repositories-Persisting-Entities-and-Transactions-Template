package com.yaksha.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaksha.assignment.entity.Order;
import com.yaksha.assignment.service.TransactionService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private final TransactionService transactionService;

	@Autowired
	public OrderController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	// Place an order
	@PostMapping
	public void placeOrder(@RequestBody Order order) {
		transactionService.placeOrder(order);
	}
}
