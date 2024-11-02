package com.cg.medicalapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.medicalapp.entity.Customer;
import com.cg.medicalapp.exception.UserNotFoundException;

@Service
public interface CustomerService {

	public Customer addCustomer(Customer customer);
	public Customer removeCustomer(Customer customer);
	public Customer viewCustomer(Customer c);
	public Customer updateCustomer(Customer c,int customerId);
	public List<Customer> viewAllCustomer();
	//public boolean validateCustomer(int customerId,String emailId, String password) throws UserNotFoundException;
	public Customer login(String emailId,String password);
}
