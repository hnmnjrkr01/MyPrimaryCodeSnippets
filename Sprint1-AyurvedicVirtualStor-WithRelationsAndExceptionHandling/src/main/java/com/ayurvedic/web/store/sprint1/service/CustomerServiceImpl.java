package com.ayurvedic.web.store.sprint1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayurvedic.web.store.sprint1.entities.Customer;
import com.ayurvedic.web.store.sprint1.repository.ICustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepository;

	
	@Override
	public Customer addCustomer(Customer customer) {
		Customer customer_added = customerRepository.save(customer);
		return customer_added;
	}

	@Override
	public List<Customer> viewAllCustomer() {
		return customerRepository.findAll();
	}
	

}
