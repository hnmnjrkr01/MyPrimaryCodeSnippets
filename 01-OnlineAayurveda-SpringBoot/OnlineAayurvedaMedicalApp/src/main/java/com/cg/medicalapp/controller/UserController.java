package com.cg.medicalapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.medicalapp.entity.User;
import com.cg.medicalapp.exception.RecordExistsException;
import com.cg.medicalapp.exception.RecordNotFoundException;
import com.cg.medicalapp.service.UserService;

@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = {"/api/v1/user"})
    public ResponseEntity<String> addUser(@Valid @RequestBody User user) throws RecordExistsException {

        userService.addUser(user);
        return new ResponseEntity<>("User added Sucessfully!", HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = {"/api/v1/user/{userId}"})
    public ResponseEntity<String> removeUser(@Valid @PathVariable("userId") int userId) throws RecordNotFoundException {
        userService.removeUser(userId);
        return new ResponseEntity<>("User removed successfully !!", HttpStatus.ACCEPTED);
    }

    @GetMapping(value = {"/api/v1/users"})
    public ResponseEntity<List<User>> getAllUsersInfo() {

        List<User> allUsers = userService.getAllUsersInfo();
        return new ResponseEntity<>(allUsers, HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/api/v1/user/{userId}")
	public ResponseEntity<User> getUser(@Valid @PathVariable("userId") int userId) {
		User user = userService.getUser(userId);
		ResponseEntity<User> retvalue = new ResponseEntity<User>(user, HttpStatus.OK);
		return retvalue;
	}

    @PutMapping(value={"/api/v1/updatePassword/{newpass}"})
    public ResponseEntity<User> updatePassword(@RequestBody User user, @PathVariable("newpass") String password){
       return  ResponseEntity.ok(userService.updatePassword(user, password));
    }
    

}

