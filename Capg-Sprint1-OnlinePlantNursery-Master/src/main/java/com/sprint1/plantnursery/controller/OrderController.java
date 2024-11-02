package com.sprint1.plantnursery.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sprint1.plantnursery.entity.OrderTable;
import com.sprint1.plantnursery.entity.Plant;
import com.sprint1.plantnursery.exceptions.OrderIdNotFoundException;
import com.sprint1.plantnursery.exceptions.PlantIdNotFoundException;
import com.sprint1.plantnursery.service.IOrderService;

/*Controller Class for Order Controller
Created By: Sakshi Shah
*/
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/Orders")
public class OrderController{
	
	@Autowired
	private IOrderService orderService;
	
	/* Method: addOrder
	 * Description: It allows to add the order.
	 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
	 * @RestController: It is used to create RESTful web services using MVC.
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URL expression.
	 * @Autowired: It enables to inject object dependency implicitly.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
	 * @PathVariable: It is used to handle template variables in the request URL
     */
	
	@PostMapping("/addOrder")
	public ResponseEntity<OrderTable> addOrder(@RequestBody OrderTable order) {
		return new ResponseEntity<OrderTable>(orderService.addOrder(order), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteOrder/id/{bookingId}")
	public ResponseEntity<OrderTable> deleteOrder(@PathVariable int bookingId) throws OrderIdNotFoundException{
		//logger.trace("deleting the whole plant");	
		return new ResponseEntity<OrderTable>(orderService.deleteOrder(bookingId), HttpStatus.OK);
	}
	
	@GetMapping("/viewOrder/id/{bookingId}")
	public ResponseEntity<OrderTable> viewOrder(@PathVariable int bookingId) {
		return new ResponseEntity<OrderTable>(orderService.viewOrder(bookingId), HttpStatus.OK);
	}
	
//*********************************************************************************************************************	
	
		/* Method: removeOrder
		 * Description: It allows to remove the Order.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URL expression.
	     */
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<List<OrderTable>> viewAllOrders(){
		return new ResponseEntity<List<OrderTable>>(orderService.viewAllOrders(), HttpStatus.OK);
	}	
	
//*********************************************************************************************************************	

		/* Method: updateOrder
		 * Description: It allows to update the order.
		 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URL expression.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
	     */
	
	@PutMapping({"/updateOrder/id/{bookingId}"})
	public ResponseEntity<OrderTable> updateOrder(@RequestBody OrderTable order, @PathVariable int bookingId) {
		// logger.trace("updating the whole plant having id "+ id);  
		orderService.updateOrder(order, bookingId);
		return new ResponseEntity<OrderTable>(order, HttpStatus.ACCEPTED);
	}
	
}