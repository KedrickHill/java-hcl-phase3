package com.project.SpringSecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {

	@GetMapping("/index")
	public String mainPage() {
		return "index";
	}
	
	
}
