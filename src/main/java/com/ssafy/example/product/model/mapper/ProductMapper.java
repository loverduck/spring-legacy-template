package com.ssafy.example.product.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.example.product.model.dto.Product;

@Mapper
public interface ProductMapper {
	int addProduct(Product product);
	
	List<Product> productList();
	
	List<Product> productListByMember(String id);
	
	Product productDetail(String code);
	
	int updateProduct(Product product);
	
	int deleteProduct(String code);
}
