package com.project.Authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.Authentication.services.AuthenticationService;

public class AuthenticationController {

	@Autowired
	AuthenticationService authService;
	
	@GetMapping("/")
	public String showGreeting(ModelMap m) {
		return "greeting";
	}
	@GetMapping("/Auth")
	public String showLogin(ModelMap m) {
		return "Auth";
	}
	
	@PostMapping("/Auth")
	public String authenticateUser(@RequestParam("username") String username,
			@RequestParam("password") String pswd) {
		return "success";
	}
}
