package j2ee.fullStack.basepackage.service;

import java.util.List;

import j2ee.fullStack.basepackage.exceptions.UserDoesNotExist;
import j2ee.fullStack.basepackage.model.User;

public interface UserService {

	User addUser(User user);
	List<User> showAllUsers();
	User updateUser(User user, long userId) throws UserDoesNotExist;
	User removeUser(long userId);
	
}
