package com.example.funiture_ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.funiture_ecommerce.entity.Cart;
import com.example.funiture_ecommerce.entity.Product;
import com.example.funiture_ecommerce.exception.OurRuntimeException;
import com.example.funiture_ecommerce.repository.CartRepository;
import com.example.funiture_ecommerce.repository.ProductRepository;
import com.example.funiture_ecommerce.requestDto.CartRequestDto;

@Service
public class CartService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartRepository cartRepository;

	public void addToCart(CartRequestDto dto) {
		Product product = productRepository.findById(dto.getProductId())
		.orElseThrow(() -> new OurRuntimeException(null, "product not found"));
		
		Cart cart = new Cart();
		cart.setProduct(product);
		cart.setQuantity(1);
		Double subTotal = product.getPrice() * cart.getQuantity();
		cart.setSubTotal(subTotal);
		cartRepository.save(cart);
	}

}
