package com.example.funiture_ecommerce.service;

import org.springframework.stereotype.Service;

import com.example.funiture_ecommerce.entity.User;
import com.example.funiture_ecommerce.repository.UserRepository;
import com.example.funiture_ecommerce.requestDto.UserRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;

	public void create(UserRequestDto dto) {
		User user = new User();
		user.setId(null);
		user.setName(dto.getName());
		user.setSurname(dto.getSurname());
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		userRepository.save(user);
		
	}

}
