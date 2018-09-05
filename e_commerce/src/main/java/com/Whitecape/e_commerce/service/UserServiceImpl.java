package com.Whitecape.e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.Whitecape.e_commerce.model.User;
import com.Whitecape.e_commerce.repository.RoleRepository;
import com.Whitecape.e_commerce.repository.UserRepository;

import java.util.HashSet;
import java.util.Optional;



@Service

public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		return userRepository.save(user);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public User find(String userName) {
		return userRepository.findOneByUsername(userName);
	}

	public Optional<User> find(Long id) {
		return userRepository.findById(id);
	}

}
