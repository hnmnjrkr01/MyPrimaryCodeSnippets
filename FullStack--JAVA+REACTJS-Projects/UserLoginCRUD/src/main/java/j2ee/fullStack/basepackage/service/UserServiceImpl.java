package j2ee.fullStack.basepackage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import j2ee.fullStack.basepackage.exceptions.UserDoesNotExist;
import j2ee.fullStack.basepackage.model.User;
import j2ee.fullStack.basepackage.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> showAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user, long userId) throws UserDoesNotExist{
		// TODO Auto-generated method stub
		
		Optional<User> updateUser = userRepository.findById(userId);
		
		if(updateUser.isPresent()) { 
			User userUpdating = updateUser.get();
			User updatedUser = new User(userId,userUpdating.getUsername(),userUpdating.getName(), userUpdating.getEmail());
			return userUpdating;
		}
		else
			 throw new UserDoesNotExist("User with id" + userId+" does not exist.");
			
		
	}

	@Override
	public User removeUser(long userId) {
		// TODO Auto-generated method stub
		Optional<User> deletedUser = userRepository.findById(userId);
		userRepository.deleteById(userId);
		return deletedUser.get();
	}
	
	

}
