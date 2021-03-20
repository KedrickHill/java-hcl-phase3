package com.project.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.project.Authentication.entities.User;
import com.project.Authentication.repositories.AuthenticationRepository;


@DataJpaTest
/*
 * @ExtendWith(SpringExtension.class)
 */public class AuthenticationApplicationTests {
	
	
	
	
	  @Autowired
	    private TestEntityManager entityManager;

	    @Autowired
	    private AuthenticationRepository authRepo;


	    @Test
	    public void whenFindByName_thenReturnUser() {
	        // given

	        User dummyUser = new User();
	        dummyUser.setName("Dummy");
	        dummyUser.setEmail("test@test.com");
	        dummyUser.setPassword("password");
	        entityManager.persist(dummyUser);
	        entityManager.flush();

	        // when
	        Optional<User> found = authRepo.findUserByName(dummyUser.getName());

	        User foundUser = (found.isPresent()) ? found.get() : new User();
	        // then

	        assertEquals(foundUser.getName(), dummyUser.getName());
	    }
	
	
	
	/*
	 * @Autowired
	 * 
	 * @PersistenceContext private TestEntityManager entityManager;
	 * 
	 * @Autowired private AuthenticationService authService;
	 * 
	 * @Autowired private AuthenticationRepository authRepo;
	 * 
	 * 
	 * @BeforeAll private static void Setup() {
	 * 
	 * }
	 * 
	 * 
	 * @Test public void shouldGetUserByName () { User testUser = new User(1,
	 * "dummy", "dummy@testdummy.edu", "TestDummy4Life");
	 * entityManager.persist(testUser); entityManager.flush(); User test =
	 * authService.GetUserByName("dummy"); assertEquals(testUser.getName(),
	 * test.getName()); }
	 * 
	 * @Test public void shouldFindUserByName() throws UserNotFoundException{ User
	 * testUser = new User(1, "dummy", "dummy@testdummy.edu", "TestDummy4Life");
	 * entityManager.persist(testUser); entityManager.flush(); Optional<User> temp =
	 * authRepo.findUserByName("dummy"); User tempUser = (temp.isPresent()) ?
	 * temp.get() : new User(); assertEquals(testUser.getName(),
	 * tempUser.getName());
	 * 
	 * tempUser = new User();
	 * assertFalse(testUser.getName().equals(tempUser.getName())); }
	 */
}
