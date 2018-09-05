package com.Whitecape.e_commerce.service;

import java.util.Optional;

import com.Whitecape.e_commerce.model.User;

public interface UserService {

	public User save(User user);
	public User update(User user);
	public User find(String userName);
	public Optional<User> find(Long id);

}
