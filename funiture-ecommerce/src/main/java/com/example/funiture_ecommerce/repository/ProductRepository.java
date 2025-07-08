package com.example.funiture_ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.funiture_ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
