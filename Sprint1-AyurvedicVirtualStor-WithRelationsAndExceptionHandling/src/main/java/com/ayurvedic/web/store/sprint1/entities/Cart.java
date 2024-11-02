package com.ayurvedic.web.store.sprint1.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	private int quantity;
	private float cost;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_cutomerId")
	private Customer customer;
	
	
	@OneToMany(mappedBy = "medicineCart" ,cascade = CascadeType.ALL)
	@JsonIgnoreProperties
	private List<Medicine> medicine;
	
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
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
	}
	
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
