package com.Whitecape.e_commerce.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Whitecape.e_commerce.model.User;
import com.Whitecape.e_commerce.repository.UserRepository;

import reactor.core.publisher.Mono;

public class UserController {
	 private final UserRepository users;

	    public UserController(UserRepository users) {
	        this.users = users;
	    }

	    @CrossOrigin(origins = "http://localhost:4200")
	    @GetMapping("/users/{username}")
	    public Mono<User> get(@PathVariable() String username) {
	        return this.users.findByUsername(username);
	    }

}
