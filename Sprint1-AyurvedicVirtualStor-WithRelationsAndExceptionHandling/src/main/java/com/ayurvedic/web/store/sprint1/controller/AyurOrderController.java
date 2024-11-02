package com.ayurvedic.web.store.sprint1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayurvedic.web.store.sprint1.entities.AyurOrder;
import com.ayurvedic.web.store.sprint1.exceptions.OrderNotPlacedException;
import com.ayurvedic.web.store.sprint1.service.IAyurOrderService;

@RestController
@RequestMapping("/ayurvedaStore")
public class AyurOrderController {

//	private static final HttpStatus HttpStatus = null;
	
	@Autowired
	IAyurOrderService orderService;
	
	@PostMapping(path="/addOrder")
	public ResponseEntity<AyurOrder> addOrder(@RequestBody  AyurOrder order){
		if(order.getOrderId()==0)
			return new ResponseEntity("Invalid",HttpStatus.NOT_FOUND);
		
		AyurOrder medcineAdded = orderService.addOrder(order);
		return new ResponseEntity(medcineAdded,HttpStatus.OK);
	}

	@GetMapping(path="/showAllOrder")
	public ResponseEntity<List<AyurOrder>> showAllOrder( AyurOrder medicine){
		return new ResponseEntity<List<AyurOrder>>(orderService.showAllOrders(),HttpStatus.OK);
	}
	
	
	@GetMapping(path="/showOrder/{orderId}")
	public ResponseEntity<AyurOrder> showOrder(@PathVariable("orderId") int orderId){
		AyurOrder orderToShow = orderService.showOrder(orderId);
		
		if(orderToShow == null)
			throw new OrderNotPlacedException("Order with id "+orderId+" never placed!!");
		else
			return new ResponseEntity<AyurOrder>(orderToShow,new HttpHeaders(),HttpStatus.OK);
	}
	
	/*
	 * @GetMapping(path="/showAllOrder/{customerId}")
		public ResponseEntity<List<AyurOrder>> showOrderByCustomerId(@PathVariable("customerId")int customerId){
			return null;
		}
	*/
	
	@PutMapping(path="/updateOrder")
	public ResponseEntity<AyurOrder> updateOrder(@RequestBody AyurOrder order){	
		order = orderService.updateOrder(order);		
		return new ResponseEntity<AyurOrder>(order,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PutMapping(path="/updateOrderStatus/{orderId}/{status}")
	public ResponseEntity<AyurOrder> updateOrderStatus(@PathVariable("orderId") int orderId, @PathVariable("status")String status){
		
		AyurOrder updatedStatus = orderService.updateOrderStatus(orderId, status);
		return new ResponseEntity<AyurOrder>(updatedStatus,new HttpHeaders(),HttpStatus.OK);

	}
	
	@DeleteMapping(path="/cancelOrder/{orderId}")
	public ResponseEntity<AyurOrder> cancelOrder(@PathVariable("orderId") int orderId){
		
		AyurOrder canceledOrder = orderService.cancelOrder(orderId);
		return new ResponseEntity<AyurOrder>(canceledOrder,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping(path="/totalCost/{orderId}/{cost}")
	public ResponseEntity<String> totalCost(@PathVariable("orderId") int orderId, @PathVariable("cost") double cost){
		double totalCost = orderService.totalCost(orderId,cost);
		return new ResponseEntity<String>("Total Cost = "+totalCost,new HttpHeaders(),HttpStatus.OK);
	}
	
	
}
