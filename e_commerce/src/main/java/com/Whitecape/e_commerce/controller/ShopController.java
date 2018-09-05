package com.Whitecape.e_commerce.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Whitecape.e_commerce.model.Shop;
import com.Whitecape.e_commerce.repository.ShopRepository;

@RestController()
public class ShopController {
	@Autowired 
	ShopRepository shopRepository;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/shops")
	public Collection<Shop> getProd() {
	     return shopRepository.findAll().stream()
	            .collect(Collectors.toList());
	 }
}
