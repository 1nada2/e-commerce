package com.Whitecape.e_commerce.service;

public interface SecurityService {

    String findLoggedInUsername();
   void autologin(String username, String password);

}
