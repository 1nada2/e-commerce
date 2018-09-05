package com.Whitecape.e_commerce.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Whitecape.e_commerce.model.User;
import com.Whitecape.e_commerce.repository.UserRepository;


import reactor.core.publisher.Mono;
@RestController()
public class UserController {
	@Autowired
	 private  UserRepository users;

	    @CrossOrigin(origins = "http://localhost:4200")
	    @GetMapping("/users/{username}")
	    public User get(@PathVariable() String username) {
	        return this.users.findOneByUsername(username);
	    }
	    @CrossOrigin(origins = "http://localhost:4200")
	    @GetMapping("/users")
		public Collection<User> GetUser() {
		    return users.findAll().stream()
		            .collect(Collectors.toList());
		}
	    

}
