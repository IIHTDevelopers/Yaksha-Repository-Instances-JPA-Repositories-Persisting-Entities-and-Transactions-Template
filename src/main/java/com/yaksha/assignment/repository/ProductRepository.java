package com.yaksha.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yaksha.assignment.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
