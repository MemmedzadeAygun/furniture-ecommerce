package com.example.funiture_ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.funiture_ecommerce.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
