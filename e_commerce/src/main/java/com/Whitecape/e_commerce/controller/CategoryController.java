package com.Whitecape.e_commerce.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Whitecape.e_commerce.model.Category;
import com.Whitecape.e_commerce.repository.CategoryRepository;

@RestController()
public class CategoryController {
	@Autowired 
	CategoryRepository categoryRepository;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/cat")
	public Collection<Category> getProd() {
	     return categoryRepository.findAll().stream()
	            .collect(Collectors.toList());
	 }
	
}
