package com.example.funiture_ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.funiture_ecommerce.requestDto.ProductRequestDto;
import com.example.funiture_ecommerce.service.ProductService;

@RestController
@RequestMapping(path = "/products")
@CrossOrigin(origins = "*")
public class ProductController {

//	@GetMapping(path = "/getAll")
//	public String get() {
//		return "get all products";
//	}
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(path = "/create")
	public void createProduct(@RequestBody ProductRequestDto d) {
		productService.create(d);
	}
	
}
