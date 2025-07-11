package com.example.funiture_ecommerce.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
	private Integer id;
	private String name;
	private Double price;
	private String image;
}
