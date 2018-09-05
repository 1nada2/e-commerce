package com.Whitecape.e_commerce.controller;

import org.springframework.http.MediaType;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Whitecape.e_commerce.model.User;
import com.Whitecape.e_commerce.service.UserService;

import util.CustomErrorType;


@RestController
@RequestMapping("account")
public class AccountController {

	public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private UserService userService;
	@Autowired
    PasswordEncoder passwordEncoder;

	// request method to create a new account by a guest
	@CrossOrigin
	
	@RequestMapping(value = "/register", //
    method = RequestMethod.POST) //
   
@ResponseBody
	public ResponseEntity<?> createUser(@RequestBody User newUser) {
		if (userService.find(newUser.getUsername()) != null) {
			logger.error("username Already exist " + newUser.getUsername());
			return new ResponseEntity(
					new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
					HttpStatus.CONFLICT);
		}
		newUser.setRole("USER");
	
		newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
		
		return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
	}

	// this is the login api/service
	@CrossOrigin
	 @RequestMapping(value = "/login")
	public Principal user(Principal principal) {
		logger.info("user logged "+principal);
		return principal;
	}
	// POST Login
    // @return "Authorization string".
    private static String postLogin(String username, String password) {
  
        // Request Header
        HttpHeaders headers = new HttpHeaders();
  
        // Request Body
        MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
        parametersMap.add("username", username);
        parametersMap.add("password", password);
  
        // Request Entity
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parametersMap, headers);
  
        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();
  
        // POST Login
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/login", //
                HttpMethod.POST, requestEntity, String.class);
  
        HttpHeaders responseHeaders = response.getHeaders();
  
        List<String> list = responseHeaders.get("Authorization");
        return list == null || list.isEmpty() ? null : list.get(0);
    }

	
	
}