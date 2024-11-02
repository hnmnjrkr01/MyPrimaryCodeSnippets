package com.ayurvedic.web.store.sprint1.service;

import java.util.List;

import com.ayurvedic.web.store.sprint1.entities.Cart;

public interface ICartService {
	
	public Cart addCart(Cart cart);
	public List<Cart> showAll();

}
