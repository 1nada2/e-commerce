package com.Whitecape.e_commerce.service;
import org.slf4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.Whitecape.e_commerce.controller.AccountController;
import com.Whitecape.e_commerce.model.Role;
import com.Whitecape.e_commerce.model.User;
import com.Whitecape.e_commerce.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.Mono;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	public static final Logger logger = LoggerFactory.getLogger(AccountController.class);
  /*  @Autowired
    private UserRepository userRepository;

   /* @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }*/
	@Autowired
	UserService userService;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.find(username);
		List<GrantedAuthority> authorities = new ArrayList<>();
       String r = user.getRole();
       authorities.add(new SimpleGrantedAuthority(r));
        

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), authorities);

        return userDetails;
	}
//	@Override
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		User user = userService.find(userName);
//	    String dBuserName = user.getUsername();
//	    if(dBuserName == null){
//	        throw new UsernameNotFoundException("User not authorized.");
//	    }
//	    GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
//	    UserDetails userDetails = (UserDetails)new User(dBuserName,
//	    		user.getPassword(), Arrays.asList(authority));
//	    return userDetails;
//	}

}