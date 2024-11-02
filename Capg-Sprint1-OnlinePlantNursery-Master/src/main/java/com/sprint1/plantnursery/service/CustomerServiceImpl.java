package com.sprint1.plantnursery.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint1.plantnursery.entity.Customer;
import com.sprint1.plantnursery.exceptions.UserNotFoundException;
import com.sprint1.plantnursery.repository.ICustomerRepository;

/*Controller Class for Customer Controller
Author : Saurabh Pawar
*/

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	// method to find the details of the customer using customer Id

	@Override
	public Customer getCustomer(int customerId) throws UserNotFoundException{
		Optional<Customer> findById = customerRepository.findById(customerId);

		return findById.orElseThrow(() -> new UserNotFoundException("There are no customer having id:" + customerId));
	}

	// method to get all the customers

	@Override
	public List<Customer> getAllCustomers() throws UserNotFoundException{

		if (customerRepository.findAll().isEmpty())
			throw new UserNotFoundException("There are no records");

		return customerRepository.findAll();

	}

	// method to delete the customer using customer Id

	@Override
	public Customer deleteCustomer(int customerId) throws UserNotFoundException{

		Optional<Customer> findById = customerRepository.findById(customerId);
		findById.orElseThrow(() -> new UserNotFoundException("There are no customer having id:" + customerId));

		customerRepository.deleteById(customerId);

		return findById.get();
	}
	
	// method to add the customer using
	
	@Override
	public Customer addNewCustomer(Customer customer) {
		customerRepository.save(customer);	
		return customer;
	}

	
	// method to update the customer using customer Id
	@Override
	public Customer updateCustomer(Customer customer,int customerId) throws UserNotFoundException {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if(customerOptional.isPresent()) {
			Customer customerToBeUpdated = customerOptional.get();
			customerToBeUpdated.setCustomerId(customer.getCustomerId());
			customerToBeUpdated.setCustomerName(customer.getCustomerName());
			customerToBeUpdated.setCustomerEmail(customer.getCustomerEmail());
			customerToBeUpdated.setUsername(customer.getUsername());
			customerToBeUpdated.setPassword(customer.getPassword());
			customerRepository.save(customerToBeUpdated);
			return customerToBeUpdated;
		}
		return customerOptional.orElseThrow(() -> new UserNotFoundException("User Not Found"));
	}

	@Override
	public Customer validateCustomer(Customer customer,String username, String password) {
		if (username == null && password == null) {
			System.out.println("Values cannot be empty");
		}
		return customer;
	}

}