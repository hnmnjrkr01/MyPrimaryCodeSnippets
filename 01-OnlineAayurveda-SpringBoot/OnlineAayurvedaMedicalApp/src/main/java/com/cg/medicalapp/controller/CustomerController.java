package com.cg.medicalapp.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.medicalapp.entity.Customer;
import com.cg.medicalapp.exception.RecordNotFoundException;
import com.cg.medicalapp.exception.UserNotFoundException;
import com.cg.medicalapp.service.CartService;
import com.cg.medicalapp.service.CustomerService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@CrossOrigin("*")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CartService cartService;

	@PostMapping("/api/v1/customer")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {
		customer = customerService.addCustomer(customer);
		cartService.createCart(customer);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@DeleteMapping("/api/v1/customer/{customerId}")
	public ResponseEntity<Customer> removeCustomer( @PathVariable("customerId") Integer customerId) {
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer = customerService.removeCustomer(customer);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@GetMapping("/api/v1/customer/{customerId}")
	public ResponseEntity<Customer> viewCustomerBycustomerId( @PathVariable("customerId") Integer customerId)
			throws RecordNotFoundException { 
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		Customer customer1 = customerService.viewCustomer(customer);
		return new ResponseEntity<>(customer1, HttpStatus.OK);
	}

	@PutMapping("/api/v1/customer/id/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer,@PathVariable int customerId)
			throws RecordNotFoundException {
		customer = customerService.updateCustomer(customer, customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@GetMapping("/api/v1/customers")
	public ResponseEntity<List<Customer>> viewAllCustomer() throws RecordNotFoundException {
		List<Customer> customerList = customerService.viewAllCustomer();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}
	
//	@GetMapping("/api/v1/validate")
//	public ResponseEntity<String> validateCustomer(@RequestBody String emailId, String password){
//		try {
//			if(customerService.validateCustomer( emailId, password)) {
//				String s="Correct Credentials";
//				return new ResponseEntity<>(s, HttpStatus.OK);
//			} else {
//				String s="Wrong credentials";
//				return new ResponseEntity<>(s, HttpStatus.OK);
//			}
//		} catch (UserNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//		return null;
//	}
	
	
	
    @PostMapping(value="/api/v1/login" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Customer> login(@RequestBody ObjectNode request) {
        String emailId = request.get("emailId").asText();
        String password = request.get("password").asText();
        return ResponseEntity.ok(customerService.login(emailId,password));
    }
}
