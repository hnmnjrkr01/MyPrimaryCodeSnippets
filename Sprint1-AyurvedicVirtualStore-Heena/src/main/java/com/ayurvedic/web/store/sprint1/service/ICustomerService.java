package com.ayurvedic.web.store.sprint1.service;

import java.util.List;

import com.ayurvedic.web.store.sprint1.entities.Customer;

public interface ICustomerService {
	
	public Customer addCustomer(Customer customer);
	public List<Customer> viewAllCustomer();

}
