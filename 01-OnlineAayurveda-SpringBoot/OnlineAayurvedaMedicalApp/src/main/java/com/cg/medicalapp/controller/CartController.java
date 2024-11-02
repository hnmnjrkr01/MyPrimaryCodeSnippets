package com.cg.medicalapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.medicalapp.entity.Cart;
import com.cg.medicalapp.entity.Medicine;
import com.cg.medicalapp.entity.Order;
import com.cg.medicalapp.exception.RecordNotFoundException;
import com.cg.medicalapp.service.CartService;
import com.cg.medicalapp.service.OrderService;

@CrossOrigin("*")
@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;
   
	@Autowired
	private OrderService orderService;
	
    @GetMapping("/api/v1/carts")
    public ResponseEntity<List<Cart>> findAllCarts()
    {
    	return new ResponseEntity<List<Cart>>(cartService.showAll(), HttpStatus.OK); 
    }

    @GetMapping("/api/v1/medicines/{cartId}")
    public ResponseEntity<List<Medicine>> viewMedicine(@PathVariable("cartId") int cartId) throws RecordNotFoundException
    {
		return new ResponseEntity<List<Medicine>>(cartService.viewMedicines(cartId), HttpStatus.OK);
    	
    }
    
    @GetMapping("/api/v1/cart/{cartId}")
    public ResponseEntity<Cart> viewCartInfo(@PathVariable("cartId") int cartId) throws RecordNotFoundException
    {
    	return new ResponseEntity<Cart>(cartService.viewCartInfo(cartId), HttpStatus.OK);
    }
    
    @DeleteMapping("/api/v1/cart/{cartId}/{medicineId}")
    public ResponseEntity<Cart> deleteMedicine(@PathVariable("cartId") int cartId,@PathVariable("medicineId") int medicineId) throws RecordNotFoundException
    {
		return new ResponseEntity<Cart>(cartService.deleteMedicine(cartId, medicineId), HttpStatus.OK);
    }
    
    @DeleteMapping("/api/v1/medicines/{cartId}")
    public ResponseEntity<Cart> deleteMedicines(@PathVariable("cartId") int cartId)throws RecordNotFoundException
    {
    	return new ResponseEntity<Cart>(cartService.deleteMedicines(cartId), HttpStatus.OK);
    }
    
    @PostMapping("/api/v1/order/{cartId}/{medicineId}")
    public ResponseEntity<Order> addOrder(@PathVariable("cartId") int cartId,@PathVariable("medicineId") int medicineId){
			return new ResponseEntity<>(orderService.addOrder(cartId, medicineId),HttpStatus.CREATED);
    }
    
}

