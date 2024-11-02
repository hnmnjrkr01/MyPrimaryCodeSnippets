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
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue
	private int cutomerId;
	private String customerName;
	private String mobileNumber;
	private String email;
	private String password;
	
	@OneToOne(mappedBy = "customer")
	private Cart cart;
	
	
	@OneToMany(mappedBy = "ayurOderCustomer",cascade = CascadeType.ALL)
	@JsonIgnoreProperties
	private List<AyurOrder> ayurOrder;
	
	public int getCutomerId() {
		return cutomerId;
	}
	public void setCutomerId(int cutomerId) {
		this.cutomerId = cutomerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "Customer [cutomerId=" + cutomerId + ", customerName=" + customerName + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", password=" + password + "]";
	}
	
	

}
