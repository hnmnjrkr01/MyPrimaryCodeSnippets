package com.cg.medicalapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.medicalapp.entity.Order;

@Repository	
public interface OrderRepository extends CrudRepository<Order,Integer>{
	
	@Query("select o from Order o where o.customer.customerId=:id")
	List<Order> findByCustomer(@Param("id") int id);
}
