package com.cg.medicalapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.medicalapp.entity.User;
import com.cg.medicalapp.exception.RecordExistsException;
import com.cg.medicalapp.exception.UserNotFoundException;
import com.cg.medicalapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	//adding user
	@Override
	public User addUser(User user) throws RecordExistsException{
		
		Optional<User> user1 = userRepository.findById(user.getUserId());
		if(user1.isPresent()) {

			throw new RecordExistsException("userId already found");
		}
		user = userRepository.save(user);
		return user;
	}

	
	//View all users
	@Override
	public List<User> getAllUsersInfo(){
		List<User> allusers= userRepository.findAll();
		return allusers;
	}
	
	//View user using Id
	@Override
	public User getUser(int userId) throws UserNotFoundException{
		Optional<User> user1 = userRepository.findById(userId);
		if(userRepository.existsById(userId)) {
			return user1.get();
		}
		else {
			throw new UserNotFoundException("User not found!");
		}
	}

	//Update user password
	@Override
	public User updatePassword(User user, String newPassword) throws UserNotFoundException{
		
		Optional<User> user1 = userRepository.findById(user.getUserId());
		
		if(!(user1.isPresent())) {
			throw new UserNotFoundException("User Not Found");
		}
			
		if(userRepository.existsById(user.getUserId())) {
			user1.get().setPassword(newPassword);
			user = user1.get();
			user = userRepository.save(user);
		}

		return user;
	}
	
	@Override
	public User removeUser(int userId) throws UserNotFoundException
	{
		Optional<User> opt=userRepository.findById(userId);
		if(opt.isPresent()) {
			userRepository.deleteById(userId);
		} else {
			throw new UserNotFoundException("User not found in the Database");
		}
		return opt.get();
	
	}
	
}
