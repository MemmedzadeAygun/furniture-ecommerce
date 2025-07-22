package com.example.funiture_ecommerce.response;

import com.example.funiture_ecommerce.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDto {
	private Integer id;
	private Integer quantity;
	private Double subTotal;
	private Product product;
	
	private Integer userId;
}
