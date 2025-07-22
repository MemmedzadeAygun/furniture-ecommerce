package com.example.funiture_ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.funiture_ecommerce.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

	List<Cart> findAllByUserId(Integer id);

}
