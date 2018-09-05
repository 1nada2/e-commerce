package com.Whitecape.e_commerce.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.Whitecape.e_commerce.model.Category;
import com.Whitecape.e_commerce.model.User;
import com.Whitecape.e_commerce.repository.CategoryRepository;
import com.Whitecape.e_commerce.repository.UserRepository;

public class customercontroller {
	@Autowired 
	UserRepository user;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/customers")
	public Collection<User> getProd() {
	     return user.findAll().stream()
	            .collect(Collectors.toList());
	 }
}
