package com.ayurvedic.web.store.sprint1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayurvedic.web.store.sprint1.entities.User;
import com.ayurvedic.web.store.sprint1.repository.IUserRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	@Autowired
	IUserRepository userRepository;
	
	public User addUser(User user) {
		User user_added = userRepository.save(user);
		return user_added;
	}

	@Override
	public List<User> getAllUserInfo() {
		return userRepository.findAll();
	}

}
