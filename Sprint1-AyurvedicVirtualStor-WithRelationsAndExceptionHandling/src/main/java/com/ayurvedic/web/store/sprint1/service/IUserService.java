package com.ayurvedic.web.store.sprint1.service;

import java.util.List;

import com.ayurvedic.web.store.sprint1.entities.User;

public interface IUserService {
	
	public User addUser(User user);
	public List<User> getAllUserInfo();

}
