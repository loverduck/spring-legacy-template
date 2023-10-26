package com.ssafy.example.product.model.service;

import java.util.List;

import com.ssafy.example.product.model.dto.Product;

public interface ProductService {
	void addProduct(Product product);
	
	List<Product> productList();
}
