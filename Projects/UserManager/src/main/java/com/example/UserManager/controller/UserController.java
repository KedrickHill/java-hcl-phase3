package com.example.UserManager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.UserManager.entities.User;
import com.example.UserManager.services.UserService;

@Controller
public class UserController {
//controls the functionality of the user entity
	
	@Autowired
	private UserService userService;

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/users")
	public String showUsers(ModelMap model) {
		logger.info("Getting all users");
		Iterable<User> users = userService.GetAllUsers();
		logger.info("Passing users to view");
		model.addAttribute("users", users );
		return "users";
	}
	 
	@RequestMapping(value ="/search", method = RequestMethod.POST)
	public String searchUser(ModelMap model, @RequestParam("id") int id) {
		logger.info("Searching for a user");
		User user = userService.GetUserById(id);
		logger.info("Passing Searched User to View");
		model.addAttribute("userSearch", user);
		return "search";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateUser(ModelMap model) {
		logger.info("Updating a User");
		User user = userService.GetUserById(1);
		return "update";
	}

}
