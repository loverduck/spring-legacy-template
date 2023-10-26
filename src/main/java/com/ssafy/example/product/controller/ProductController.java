package com.ssafy.example.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.example.product.model.dto.Product;
import com.ssafy.example.product.model.service.ProductServiceImpl;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductServiceImpl productService;
	
	@GetMapping("/regist")
	public String registProduct() {
		return "regist";
	}
	
	@PostMapping("/regist")
	public String registProduct(@ModelAttribute Product product) {
		productService.addProduct(product);
		return "redirect:/product/list";
	}

	
	@GetMapping("/list")
	public String listProduct(Model model) {
		model.addAttribute("products", productService.productList());
		return "list";
	}
	
}
