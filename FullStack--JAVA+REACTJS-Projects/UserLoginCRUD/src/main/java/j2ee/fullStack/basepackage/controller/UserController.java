package j2ee.fullStack.basepackage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import j2ee.fullStack.basepackage.exceptions.UserDoesNotExist;
import j2ee.fullStack.basepackage.model.User;
import j2ee.fullStack.basepackage.repository.UserRepository;
import j2ee.fullStack.basepackage.service.UserService;

@RestController
@RequestMapping("/UserCRUDLogin")

public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@Validated @RequestBody User user){
		return new ResponseEntity<User>(userService.addUser(user),new HttpHeaders(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/showAllUsers")
	public ResponseEntity<List<User>> showAllUsers(){
		return new ResponseEntity<List<User>>(userService.showAllUsers(), new HttpHeaders(), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<User> updateUser( @RequestBody User user,@PathVariable long userId ) throws UserDoesNotExist{
		return new ResponseEntity<User>(userService.updateUser(user,userId), new HttpHeaders(), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/removerUser/{userId}")
	public ResponseEntity<User> removerUser(@PathVariable long userId) throws UserDoesNotExist{
		return new ResponseEntity<User>(userService.removeUser(userId),new HttpHeaders(),HttpStatus.OK);
	}
}
