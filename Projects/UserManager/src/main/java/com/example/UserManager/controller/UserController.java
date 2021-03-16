package com.example.UserManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.UserManager.entities.User;
import com.example.UserManager.services.UserService;

@Controller
public class UserController {
//controls the functionality of the user entity
	
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public String showUsers(ModelMap model) {
		Iterable<User> users = userService.GetAllUsers();
		model.addAttribute("users", users );
		return "users";
	}

}
