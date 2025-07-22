package com.example.funiture_ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.funiture_ecommerce.requestDto.CartRequestDto;
import com.example.funiture_ecommerce.response.CartResponseDto;
import com.example.funiture_ecommerce.service.CartService;

@RestController
@RequestMapping(path = "/cart")
@CrossOrigin(origins = "*")
public class CartController {
	
	@Autowired
	private CartService cartService;
 
	@PostMapping(path = "/add")
	public ResponseEntity<String> addToCart(@RequestBody CartRequestDto dto){
		cartService.addToCart(dto);
		return ResponseEntity.ok("Product add to cart successfully");
	}
	
	@GetMapping(path = "/getCart") 
	public List<CartResponseDto> getCart(){
		return cartService.getCart();
	}
}
