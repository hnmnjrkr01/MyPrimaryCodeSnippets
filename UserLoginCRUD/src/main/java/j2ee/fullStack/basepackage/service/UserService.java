package j2ee.fullStack.basepackage.service;

import java.util.List;

import j2ee.fullStack.basepackage.exceptions.UserDoesNotExist;
import j2ee.fullStack.basepackage.model.User;

public interface UserService {

	User addUser(User user);
	List<User> showAllUsers();
	User showUser(Long userid);
	User updateUser(User user, Long userId) throws UserDoesNotExist;
	User removeUser(long userId);
	
}
