package com.project.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.Authentication.entities.User;
import com.project.Authentication.exceptions.UserNotFoundException;
import com.project.Authentication.repositories.AuthenticationRepository;
import com.project.Authentication.services.AuthenticationService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthenticationApplicationTests {

	@Autowired
    private static TestEntityManager entityManager;
	
	@Autowired
	private AuthenticationService authService;
	
	@Autowired
	private AuthenticationRepository authRepo;
	
	private User testUser;
	
	@BeforeAll
	private static void Setup() {
		User testUser = new User();
		testUser.setEmail("dummy@testdummy.edu");
		testUser.setName("dummy");
		testUser.setPassword("TestDummy4Life");
//		entityManager.persist(testUser);
//		entityManager.flush();
	}
	
	
	@Test
	public void shouldGetUserByName () {
		User test = authService.GetUserByName("dummy");
		assertEquals(testUser.getName(), test.getName());
	}
	
	@Test
	public void shouldFindUserByName() throws UserNotFoundException{
		Optional<User> temp = authRepo.findUserByName("dummy");
		User tempUser = (temp.isPresent()) ? temp.get() : null;
		assertEquals(testUser.getName(), tempUser.getName());
	}
}
