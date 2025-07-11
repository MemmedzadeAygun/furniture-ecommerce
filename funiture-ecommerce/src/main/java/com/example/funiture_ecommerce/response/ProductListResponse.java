package com.example.funiture_ecommerce.response;

import java.util.List;

import com.example.funiture_ecommerce.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductListResponse {

	private List<Product> products;
}
