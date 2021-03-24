package com.project.SpringSecurity.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.SpringSecurity.entities.MyUserDetails;
import com.project.SpringSecurity.entities.User;
import com.project.SpringSecurity.repositories.UsersRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UsersRepository userRepo;
	
	public User GetUserByName(String name) {
		Optional<User> user = userRepo.findUserByName(name);
		if(!user.isPresent()) throw new RuntimeException();
		return user.get();
	}
	
	public Boolean isValidLogin(String jspPass, String dbPass) {
		return (jspPass.equals(dbPass)) ? true : false;
	}

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return new MyUserDetails(GetUserByName(username));
	}

}
