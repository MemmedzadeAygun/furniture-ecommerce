package com.example.funiture_ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.funiture_ecommerce.entity.Product;
import com.example.funiture_ecommerce.exception.OurRuntimeException;
import com.example.funiture_ecommerce.repository.ProductRepository;
import com.example.funiture_ecommerce.requestDto.ProductRequestDto;
import com.example.funiture_ecommerce.response.ProductListResponse;
import com.example.funiture_ecommerce.response.ProductResponseDto;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public void create(ProductRequestDto d) {
		Product product = new Product();
		product.setId(null);
		product.setName(d.getName());
		product.setPrice(d.getPrice());
		product.setImage(d.getImage());
		productRepository.save(product);
	}

	public ProductListResponse getAll() {
		List<Product> products = productRepository.findAll();
		ProductListResponse response = new ProductListResponse();
		response.setProducts(products);
		return response;
	}

	public ProductResponseDto get(Integer id) {
		if (id == null || id<=0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}
		Optional<Product> byId = productRepository.findById(id);
		ProductResponseDto response = new ProductResponseDto();
		if (byId.isPresent()) {
			Product product = byId.get();
			response.setId(product.getId());
			response.setName(product.getName());
			response.setPrice(product.getPrice());
			response.setImage(product.getImage());
		}else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
		return response;
	}

	public void update(ProductRequestDto dto) {
		if (dto.getId() == null || dto.getId() <= 0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}
		Optional<Product> byId = productRepository.findById(dto.getId());
		if (byId.isPresent()) {
			Product product = byId.get();
			product.setId(dto.getId());
			product.setName(dto.getName());
			product.setPrice(dto.getPrice());
			product.setImage(dto.getImage());
			productRepository.save(product);
		}else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
	}

	public void delete(Integer id) {
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}
		if (productRepository.findById(id).isPresent()) {
			productRepository.deleteById(id);
		}else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
		
	}

}
