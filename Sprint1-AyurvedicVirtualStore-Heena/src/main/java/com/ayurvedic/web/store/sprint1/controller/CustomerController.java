package com.ayurvedic.web.store.sprint1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ayurvedic.web.store.sprint1.entities.Customer;
import com.ayurvedic.web.store.sprint1.service.ICustomerService;

@RestController
@RequestMapping("/ayurvedaStore")
public class CustomerController {

	private static final HttpStatus HttpStatus = null;
	
	@Autowired
	ICustomerService customerService;
	
	@PostMapping(path="/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		if(customer.getCutomerId()==0)
			return new ResponseEntity("Invalid",HttpStatus.NOT_FOUND);
		else
		{
			Customer customerInfo = customerService.addCustomer(customer);
			return new ResponseEntity(customer, HttpStatus.OK);
		}
	}
	
	@GetMapping(path="/viewAllCustomer")
	public ResponseEntity<List<Customer>> viewAllCustomer(){
		return new ResponseEntity<List<Customer>>(customerService.viewAllCustomer(),HttpStatus.OK);
	}
}
