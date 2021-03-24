package com.project.SpringSecurity.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.SpringSecurity.entities.UserLogins;

@Repository
public interface UsersRepository extends CrudRepository<UserLogins, Integer>{

	public Optional<UserLogins> findByName(String name); 
}
