package com.cg.medicalapp.service;

import java.util.List;

import com.cg.medicalapp.entity.Cart;
import com.cg.medicalapp.entity.Customer;
import com.cg.medicalapp.entity.Medicine;
import com.cg.medicalapp.exception.RecordNotFoundException;

public interface CartService {
	
	Cart createCart(Customer customer);
	List<Cart> showAll();
	Cart deleteMedicine(int cartId, int medicineId) throws RecordNotFoundException;
	Cart deleteMedicines(int cartId) throws RecordNotFoundException;
	Cart addToCart(int cartId,int medicineId) throws RecordNotFoundException;
	List<Medicine> viewMedicines(int cartId) throws RecordNotFoundException;
	Cart viewCartInfo(int cartId) throws RecordNotFoundException;
	public Cart addMedicine(int cartId,String medicineName, int qty) throws RecordNotFoundException;
	
}
