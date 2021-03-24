package com.project.SpringSecurity.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SpringSecurity.entities.UserLogins;
import com.project.SpringSecurity.repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	UsersRepository userRepo;
	
	public Optional<UserLogins> GetUserByName(String name) {
		return userRepo.findByName(name);
	}
	
	public Boolean isValidLogin(String jspPass, String dbPass) {
		return (jspPass.equals(dbPass)) ? true : false;
	}
}
