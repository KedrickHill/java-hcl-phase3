package com.project.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.project.Authentication.entities.User;
import com.project.Authentication.exceptions.UserNotFoundException;
import com.project.Authentication.repositories.AuthenticationRepository;
import com.project.Authentication.services.AuthenticationService;

@DataJpaTest
//@AutoConfigureTestDatabase
public class AuthenticationCodeTests {

	@Test
	public void dontBeAWeinerAPPCONTEXT() {
		assertEquals(true, true);
	}

		@Autowired

	@PersistenceContext
	private static TestEntityManager entityManager;

	@Autowired
	private AuthenticationService authService;

	@Autowired
	private AuthenticationRepository authRepo;

	@BeforeAll
	private static void Setup() {

		User testUser = new User(1, "dummy", "dummy@testdummy.edu", "TestDummy4Life");
		entityManager.persist(testUser);
		entityManager.flush();
	}

	@Test
	public void shouldGetUserByName() {
		
		User test = authService.GetUserByName("dummy");
		assertEquals(testUser.getName(), test.getName());
	}

	@Test
	public void shouldFindUserByName() throws UserNotFoundException {
		Optional<User> temp = authRepo.findUserByName("dummy");
		User tempUser = (temp.isPresent()) ? temp.get() : new User();
		assertEquals(testUser.getName(), tempUser.getName());

		tempUser = new User();
		assertFalse(testUser.getName().equals(tempUser.getName()));
	}

}
