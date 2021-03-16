package com.example.UserManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.UserManager.entities.User;
import com.example.UserManager.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userService.GetAllUsers();
	}

}
