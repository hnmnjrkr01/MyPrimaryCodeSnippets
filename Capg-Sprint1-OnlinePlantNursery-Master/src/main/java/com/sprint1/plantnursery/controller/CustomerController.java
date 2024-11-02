package com.sprint1.plantnursery.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sprint1.plantnursery.entity.Customer;

import com.sprint1.plantnursery.exceptions.UserNotFoundException;
import com.sprint1.plantnursery.service.ICustomerService;

/*Controller Class for Customer Controller
Author : Saurabh Pawar
*/
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/customers") // Request Mapping tells which URL will initiate what method
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	/****************************
	 * Method: addCustomers Description: It is used to add into the customers table
	 * 
	 * @returns customers It returns String type message
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given
	 *               URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type. 
	 *               
	 * Created By-Saurabh Pawar 
	 * 
	 ****************************/

	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer) {
		customerService.addNewCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}

// =========================================================================================================================================	
	
	/****************************
	 * Method: Update customers 
	 * Description: It is used to update customers in customers table
	 * @returns customers It returns String type message 
	 * @PutMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By-Saurabh Pawar
	 * 
	 ****************************/	

	@PutMapping({ "/updateCustomer/id/{customerId}" })
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable int customerId)
			throws UserNotFoundException {
		customerService.updateCustomer(customer, customerId);
		return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);
	}

// ========================================================================================================================================		
	
	/****************************
	 * Method: getAllCustomer
	 * Description: It is used to get All Customer items in Customer table
	 * @returns Customer It returns Customer  with details
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By: Saurabh Pawar
	 * 
	 ****************************/
	@GetMapping("/viewAllCustomers")
	public ResponseEntity<List<Customer>> viewAllCustomers() throws UserNotFoundException {
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}
	
// ========================================================================================================================================
	
	/****************************
	 * Method: viewCustomer by Id
	 * Description: It is used to get Customer items  by specifying Id in Customer table
	 * @returns Customer It returns Customer  with details
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By: Saurabh Pawar
	 * 
	 ****************************/
	
	@GetMapping("/viewCustomer/id/{customerId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable Integer customerId) throws UserNotFoundException {
		// logger.trace("fetching the plant with id "+ id);
		return new ResponseEntity<Customer>(customerService.getCustomer(customerId), HttpStatus.OK);
	}

	/****************************
	 * Method: deleteCustomer
	 * Description: It is used to remove the items in the customer table
	 * @returns customer It returns String type message 
	 * @DeleteMapping: It is used to handle the HTTP Delete requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By: Saurabh Pawar
	 * 
	 ****************************/
	
	@DeleteMapping("/deleteCustomer/id/{customerId}")
	public ResponseEntity<Customer> deleteById(@PathVariable Integer customerId) throws UserNotFoundException {

		return new ResponseEntity<Customer>(customerService.deleteCustomer(customerId), HttpStatus.OK);
	}
	
// ========================================================================================================================================
	
	/****************************
	 * Method: validate Customer
	 * Description: It is used to validate into Customer table
	 * @returns Customer It returns Customer with details
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By: Saurabh Pawar 
	 * 
	 ****************************/

	@GetMapping(path = "/validateCustomer/{username}/{password}")
	public ResponseEntity<Customer> validateCustomer(@PathVariable Customer customer, @PathVariable String username,
			@PathVariable String password) {
		Customer customer1 = customerService.validateCustomer(customer, username, password);

		return new ResponseEntity<Customer>(customer1, HttpStatus.OK);
	}
}