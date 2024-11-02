package com.cg.medicalapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.medicalapp.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	Optional<Customer> findByEmailIdAndPassword(String emailId, String password);
	
	
	
}
