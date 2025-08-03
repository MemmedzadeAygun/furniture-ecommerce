package com.example.funiture_ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.funiture_ecommerce.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
