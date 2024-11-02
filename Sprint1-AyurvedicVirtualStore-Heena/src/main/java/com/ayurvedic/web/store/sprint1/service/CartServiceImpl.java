package com.ayurvedic.web.store.sprint1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayurvedic.web.store.sprint1.entities.Cart;
import com.ayurvedic.web.store.sprint1.repository.ICartRepository;

@Service
@Transactional
public class CartServiceImpl implements ICartService {
	
	@Autowired
	ICartRepository cartRepository;

	@Override
	public Cart addCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepository.save(cart);
	}

	@Override
	public List<Cart> showAll() {
		// TODO Auto-generated method stub
		return cartRepository.findAll();
	}
	
	

}
