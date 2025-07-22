package com.example.funiture_ecommerce.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartRequestDto {
	private Integer productId;
	private Integer quantity;
	private Double subTotal;
}
