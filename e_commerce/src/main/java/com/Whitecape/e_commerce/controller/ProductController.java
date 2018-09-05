package com.Whitecape.e_commerce.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Whitecape.e_commerce.model.Product;
import com.Whitecape.e_commerce.repository.ProductRepository;


@RestController()
public class ProductController {
	@Autowired ProductRepository productRepository;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("prod")
	
	/*public Page<Product> getProd(Pageable pageable) {
	    return productRepository.findAll(pageable);
	}*/
	public Collection<Product> getProd() {
     return productRepository.findAll().stream()
            .collect(Collectors.toList());
 }
}
