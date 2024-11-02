package com.cg.medicalapp.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.medicalapp.entity.Cart;
import com.cg.medicalapp.entity.Customer;
import com.cg.medicalapp.entity.Medicine;
import com.cg.medicalapp.exception.RecordNotFoundException;
import com.cg.medicalapp.repository.CartRepository;
import com.cg.medicalapp.repository.MedicineRepository;



@Service
public class CartServiceImpl implements CartService{
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	MedicineRepository medicineRepository;
	
	@Override
	public Cart deleteMedicine(int cartId, int medicineId) {
		
		Optional<Cart> c=cartRepository.findById(cartId);
		Cart cart=c.get();
		Optional<Medicine> m=medicineRepository.findById(medicineId);
		Medicine medicine=m.get();
		cart.getmedicines().remove(medicine);
		cart.setQuantity(cart.getQuantity()-1);
		cart.setCost(cart.getCost()-(int)medicine.getMedicineCost());
		cartRepository.save(cart);
		return cart;
	}

	@Override
	public Cart deleteMedicines(int cartId) {
		Optional<Cart> c=cartRepository.findById(cartId);
		Cart cart=c.get();
		cart.getmedicines().clear();
		cart.setQuantity(0);
		cart.setCost(0);
		cartRepository.save(cart);
		return cart;
		
	}

	@Override
	public Cart addToCart(int cartId, int medicineId) {
		Optional<Cart> c=cartRepository.findById(cartId);
		Cart cart=c.get();
		Optional<Medicine> m=medicineRepository.findById(medicineId);
		Medicine medicine=m.get();
		cart.getmedicines().add(medicine);
		cart.setQuantity(cart.getQuantity()+1);
		cart.setCost(cart.getCost()+(int)medicine.getMedicineCost());
		cartRepository.save(cart);
		return cart;
		
		
	}

	@Override
	public List<Medicine> viewMedicines(int cartId) throws RecordNotFoundException {
		Optional<Cart> c=cartRepository.findById(cartId);
		Cart cart=c.get();
		return cart.getmedicines();
	}

	@Override
	public Cart viewCartInfo(int cartId) throws RecordNotFoundException{
		return cartRepository.findById(cartId).orElseThrow(() -> 
		new RecordNotFoundException("Cart not found with given cartId"));
		
	}

	@Override
	public Cart createCart(Customer customer) {

		int cartId=customer.getCustomerId();
		Cart c=new Cart();
		c.setCartId(cartId);
		c.setCustomer(customer);
		List<Medicine> m=new ArrayList<Medicine>();
		c.setmedicines(m);
		c.setQuantity(0);
		c.setCost(0);
		return cartRepository.save(c);
		
	}
	
	public Cart addMedicine(int cartId,String medicineName, int qty) throws RecordNotFoundException{
		
			List<Medicine> medicines=medicineRepository.findByMedicineName(medicineName);
			Optional<Cart> c=cartRepository.findById(cartId);
			if(c.isPresent()) {
				Cart cart=c.get();
				cart.getmedicines().addAll(medicines);
				cart.setQuantity(cart.getQuantity()+qty);
				cartRepository.save(cart);
				return cart;
			} 
			else {
				String s="Cart not found with id "+cartId;
				throw new RecordNotFoundException(s);
			}
		}

	@Override
	public List<Cart> showAll() {
		return cartRepository.findAll();
	} 
		
	}

