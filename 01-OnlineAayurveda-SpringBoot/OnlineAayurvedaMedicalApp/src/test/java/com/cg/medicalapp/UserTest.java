package com.cg.medicalapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.cg.medicalapp.entity.User;
import com.cg.medicalapp.exception.RecordExistsException;
import com.cg.medicalapp.exception.UserNotFoundException;
import com.cg.medicalapp.repository.UserRepository;
import com.cg.medicalapp.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class UserTest {

	@Mock
	private UserRepository repo;
	
	@InjectMocks
	private UserServiceImpl userService;
	
	private User u1;
	
	@BeforeEach
	void setUp() {
		u1=new User(1,"anand","1111111","customer");
		
	}
	
	@Test
	void testAddUser() throws RecordExistsException {
		when(repo.save(u1)).thenReturn(u1);
		User savedUser=userService.addUser(u1);
		assertNotNull(savedUser);
	}
	@Test
	void testRemoveUser() throws UserNotFoundException {
		try {
			User removeUser=userService.removeUser(1);
			assertNotNull(removeUser);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
		}
	}
	
	@Test
	void testShowAllUsers() {
		User u2=new User(2,"vamsi","vams@789","admin");
		User u3=new User(3,"kishore","kish@456","customer");
		User u4=new User(4,"anand","anand@876","admin");
		User u5=new User(5,"adithya","adit@092","customer");
		User u6=new User(6,"joshi","josh@4568","customer");
		when(repo.findAll()).thenReturn(List.of(u1,u2,u3,u4,u5,u6));
		List<User> mList= userService.getAllUsersInfo();
		assertNotNull(mList);
		assertEquals(6,mList.size());
	}


	}