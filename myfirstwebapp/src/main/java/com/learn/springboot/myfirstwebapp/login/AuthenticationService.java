package com.learn.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username, String password) {
		boolean isValidUsername=username.equalsIgnoreCase("nav");
		boolean isValidPassword=password.equalsIgnoreCase("hello");
		return isValidUsername && isValidPassword;
	}
}
