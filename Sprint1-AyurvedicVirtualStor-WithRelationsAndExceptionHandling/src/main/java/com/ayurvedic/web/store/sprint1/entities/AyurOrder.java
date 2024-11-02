package com.ayurvedic.web.store.sprint1.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ayurOrder")
public class AyurOrder {

	@Id
	@GeneratedValue
	private int orderId;
	private LocalDate orderDate;
	private LocalDate dispatchDate;
	@Column (columnDefinition="Decimal (10,2) ") 
	private double cost;
	@Column (columnDefinition="Decimal (10,2) ") 
	private double totalCost;
	private String status;
	
	
	@ManyToOne
	@JoinColumn(name = "ayur_oder_customer_ID")
	private Customer ayurOderCustomer;
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public LocalDate getDispatchDate() {
		return dispatchDate;
	}
	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/*
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	*/
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", dispatchDate=" + dispatchDate + ", cost="
				+ cost + ", totalCost=" + totalCost + ", status=" + status + "]";
	}
	
	
	
	
	

}
