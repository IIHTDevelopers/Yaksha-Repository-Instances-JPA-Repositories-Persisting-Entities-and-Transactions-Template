package com.yaksha.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yaksha.assignment.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
