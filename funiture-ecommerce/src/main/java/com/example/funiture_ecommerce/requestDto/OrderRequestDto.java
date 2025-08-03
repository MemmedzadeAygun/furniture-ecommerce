package com.example.funiture_ecommerce.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequestDto {
	
	private Integer cartId;
	private String firstName;
	private String lastName;
	private String country;
	private String address; 
	private String city;
	private String phone;
	private String email;
	private String cartNumber;
	private String zipCode;
	private String expiryMonth;
	private Integer expiryYear;
	
}
