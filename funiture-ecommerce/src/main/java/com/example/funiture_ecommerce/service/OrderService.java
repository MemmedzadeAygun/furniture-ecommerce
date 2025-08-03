package com.example.funiture_ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.funiture_ecommerce.entity.Cart;
import com.example.funiture_ecommerce.entity.Order;
import com.example.funiture_ecommerce.exception.OurRuntimeException;
import com.example.funiture_ecommerce.repository.CartRepository;
import com.example.funiture_ecommerce.repository.OrderRepository;
import com.example.funiture_ecommerce.requestDto.OrderRequestDto;

@Service
public class OrderService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	public void order(OrderRequestDto dto) {
		Cart cart = cartRepository.findById(dto.getCartId())
		.orElseThrow(() -> new OurRuntimeException(null, "cart not found"));
		
		Order order = new Order();
		order.setFirstName(dto.getFirstName());
		order.setLastName(dto.getLastName());
		order.setCountry(dto.getCountry());
		order.setAddress(dto.getAddress());
		order.setCity(dto.getCity());
		order.setPhone(dto.getPhone());
		order.setEmail(dto.getEmail());
		order.setCartNumber(dto.getCartNumber());
		order.setExpiryMonth(dto.getExpiryMonth());
		order.setExpiryYear(dto.getExpiryYear());
		order.setZipCode(dto.getZipCode());;
		order.setCart(cart);
		orderRepository.save(order);
	}

	
}
