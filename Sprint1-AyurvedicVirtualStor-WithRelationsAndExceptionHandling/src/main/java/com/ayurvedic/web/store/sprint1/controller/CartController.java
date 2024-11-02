package com.ayurvedic.web.store.sprint1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayurvedic.web.store.sprint1.entities.Cart;
import com.ayurvedic.web.store.sprint1.service.ICartService;

@RestController
@RequestMapping("/ayurvedaStore")
public class CartController {
	
	private static final HttpStatus HttpStatus = null;

	@Autowired
	ICartService cartService;
	
	@PostMapping(path="/addCart")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart){
		if(cart.getCartId()==0)
			return new ResponseEntity("Invalid",HttpStatus.NOT_FOUND);
		
		Cart cartAdded = cartService.addCart(cart);
		return new ResponseEntity(cartAdded,HttpStatus.OK);
	}

	@GetMapping(path="/showAll")
	public ResponseEntity<List<Cart>> showAll( Cart cart){
		return new ResponseEntity<List<Cart>>(cartService.showAll(),HttpStatus.OK);
	}

}
