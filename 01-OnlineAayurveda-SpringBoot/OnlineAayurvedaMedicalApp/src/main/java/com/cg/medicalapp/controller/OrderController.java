package com.cg.medicalapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.medicalapp.entity.Order;
import com.cg.medicalapp.exception.RecordNotFoundException;
import com.cg.medicalapp.service.OrderService;

@CrossOrigin("*")
@RestController
public class OrderController {
	
		@Autowired
		private OrderService orderService;
		
		@PutMapping("/api/v1/order/{id}")
		public ResponseEntity<Order> updateOrder(@Valid @PathVariable("id") int id, @RequestBody Order order) throws RecordNotFoundException{
				return new ResponseEntity<Order>(orderService.updateOrder(id,order), HttpStatus.OK);
		}
		
		@PutMapping("/api/v1/orderstatus/{id}/{status}")
		public ResponseEntity<Order> updateStatus( @Valid @PathVariable("id") int id, @PathVariable("status") String status) throws RecordNotFoundException{
				return new ResponseEntity<>(orderService.updateOrderStatus(id, status), HttpStatus.OK);
		}
		
		@DeleteMapping("/api/v1/order/{id}")
		public ResponseEntity<Order> cancelOrder(@Valid @PathVariable("id") int id) throws RecordNotFoundException{
				return new ResponseEntity<>(orderService.cancelOrder(id), HttpStatus.OK);
		}
		
		@GetMapping("/api/v1/order/{id}")
		public ResponseEntity<Order> viewOrder(@Valid @PathVariable("id") int id)throws RecordNotFoundException{
				return new ResponseEntity<>(orderService.showOrder(id), HttpStatus.OK);
		}
		
		@GetMapping("/api/v1/orders")
		public ResponseEntity<List<Order>> showAll(){
			return new ResponseEntity<>(orderService.showAllOrders(), HttpStatus.OK);
		}
		
		@GetMapping("/api/v1/orderbycustomer/{id}")
		public ResponseEntity<List<Order>> viewOrdersByCustomer(@Valid @PathVariable("id") int id) throws RecordNotFoundException{
				return new ResponseEntity<>(orderService.showOrderByCustomer(id), HttpStatus.OK);
		}
	

}