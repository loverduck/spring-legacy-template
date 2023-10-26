package com.ssafy.example.product.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.example.product.model.dto.Product;
import com.ssafy.example.product.model.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductMapper productMapper;

	@Override
	public void addProduct(Product product) {
		productMapper.addProduct(product);
	}

	@Override
	public List<Product> productList() {
		return productMapper.productList();
	}

}
