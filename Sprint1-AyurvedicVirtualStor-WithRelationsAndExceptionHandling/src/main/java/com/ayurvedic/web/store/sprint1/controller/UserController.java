package com.ayurvedic.web.store.sprint1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayurvedic.web.store.sprint1.entities.User;
import com.ayurvedic.web.store.sprint1.service.IUserService;

@RestController
@RequestMapping("/ayurvedaStore")

public class UserController {
	
private static final HttpStatus HttpStatus = null;
	
	@Autowired
	IUserService userService;
	
	@PostMapping(path="/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		if(user.getUserId()==0)
			return new ResponseEntity("Invalid",HttpStatus.NOT_FOUND);
		else {
		User userInfo = userService.addUser(user);
		return new ResponseEntity(userInfo,HttpStatus.OK);
		}
	}
	
	@GetMapping(path="/getAllUserInfo")
	public ResponseEntity<List<User>> getAllUserInfo(){
		
		return new ResponseEntity<List<User>>(userService.getAllUserInfo(),HttpStatus.OK);
	}

}
