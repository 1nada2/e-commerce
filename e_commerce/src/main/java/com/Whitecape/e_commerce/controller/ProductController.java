package com.Whitecape.e_commerce.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Whitecape.e_commerce.model.Product;
import com.Whitecape.e_commerce.repository.ProductRepository;

@RestController()
public class ProductController {
	@Autowired ProductRepository productRepository;

	@GetMapping("/products")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Product> getProd() {
	    return productRepository.findAll().stream()
	            .collect(Collectors.toList());
	}
	
	

}
