package com.ram.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/contacts")
public class ContactsController {
	
	@Autowired
	private ContactsServiceI contactService;
	
	@PostMapping(path="/create")
	public ResponseEntity<Boolean> CreateContact(@RequestBody Contacts contact){
		contactService.createContact(contact);
		ResponseEntity<Boolean> resEntity = new ResponseEntity(true, HttpStatus.OK);
		System.out.println("response entity=" + resEntity);
		return resEntity;
	} 

}
