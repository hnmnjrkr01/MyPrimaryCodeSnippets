package com.sprint1.plantnursery.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sprint1.plantnursery.entity.Customer;

/*Controller Class for Customer Controller
Author : Saurabh Pawar
*/

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	Optional<Customer> findById(Integer customerId);

}