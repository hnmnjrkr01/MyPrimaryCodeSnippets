package com.ayurvedic.web.store.sprint1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayurvedic.web.store.sprint1.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	

}
