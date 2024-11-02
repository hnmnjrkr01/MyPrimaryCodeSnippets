package com.ayurvedic.web.store.sprint1.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue
	private int cartId;
	private int quantity;
	private float cost;
	//private Customer customer;
	//private List<Medicine> medicine;
	
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	/*
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<Medicine> getMedicine() {
		return medicine;
	}
	public void setMedicine(List<Medicine> medicine) {
		this.medicine = medicine;
	}*/
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", quantity=" + quantity + ", cost=" + cost + "]";
	}
	
	
	
	
}
