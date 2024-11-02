package com.sprint1.plantnursery.repository;

/*Controller Class for Order Controller
Created By: Sakshi Shah
*/

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.plantnursery.entity.OrderTable;

/*Controller Class for Order Controller
Created By: Sakshi Shah
*/

@Repository
public interface IOrderRepository extends JpaRepository<OrderTable, Integer> {
	Optional<OrderTable> findById(Integer bookingOrderId);
}