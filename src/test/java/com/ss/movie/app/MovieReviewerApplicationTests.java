package com.ss.movie.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ss.movie.app.model.User;
import com.ss.movie.app.repo.UserRepo;

@SpringBootTest
class MovieReviewerApplicationTests {

	@Autowired
	UserRepo userRepo;
	
	@Test
	void contextLoads() {
		assertNotNull(userRepo);
	}
	
	@Test
	void check1UserCreation() {
		User user = new User();
		user.setUsername("shaan31");
		user.setEmailId("anubhav.sharma@verizon.com");
		user = userRepo.save(user);
		assertTrue(user.getId()>0);
	}
	
	@Test
	void check2GetUserbyUsername() {
		String username = userRepo.findByUsername("shaan31").getUsername();
		assertEquals("shaan31", username);
	}

}
