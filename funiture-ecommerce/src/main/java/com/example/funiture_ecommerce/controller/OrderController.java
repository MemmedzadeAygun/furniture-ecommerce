package com.example.funiture_ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.funiture_ecommerce.requestDto.OrderRequestDto;
import com.example.funiture_ecommerce.service.OrderService;

@RestController
@RequestMapping(path = "/orders")
@CrossOrigin(origins = "*")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping(path = "/add")
	public ResponseEntity<String> order(@RequestBody OrderRequestDto dto){
		orderService.order(dto);
		return ResponseEntity.ok("Order was created successfully");
	}
}
