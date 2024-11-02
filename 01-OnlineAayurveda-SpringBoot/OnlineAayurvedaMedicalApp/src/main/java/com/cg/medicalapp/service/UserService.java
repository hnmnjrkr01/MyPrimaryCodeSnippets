package com.cg.medicalapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.medicalapp.entity.User;
import com.cg.medicalapp.exception.RecordExistsException;
import com.cg.medicalapp.exception.UserNotFoundException;

@Service
public interface UserService {

	 public User addUser(User user) throws RecordExistsException;

	 public User removeUser(int userId) throws UserNotFoundException;

	 public User updatePassword(User user, String newPassword) throws UserNotFoundException;

	 public List<User> getAllUsersInfo();
	 
	 public User getUser(int userId) throws UserNotFoundException;
	 
	 
}