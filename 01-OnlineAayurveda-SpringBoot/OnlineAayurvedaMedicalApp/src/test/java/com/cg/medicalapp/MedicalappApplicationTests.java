package com.cg.medicalapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.medicalapp.entity.User;
import com.cg.medicalapp.repository.UserRepository;
import com.cg.medicalapp.service.UserService;

@SpringBootTest
class MedicalappApplicationTests {

	@MockBean
	UserRepository userRepository ;
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testUserEntity() {
		User u = new User();
		u.setUserId(1);
		u.setPassword("vams");
		u.setUserName("vamsi");
		u.setRole("admin");
		userRepository.save(u);
		assertNotNull(userRepository.findAll());
	}
	@Test
	public void testAddUser() {
		User user = new User();
		user.setUserId(1);
		user.setPassword("va");
		user.setUserName("vamsi");
		user.setRole("admin");
		Mockito.when(userRepository.save(user)).thenReturn(user);

		assertThat(userService.addUser(user)).isEqualTo(user);
		
	}
}
