package com.cg.medicalapp.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Column(name = "order_id")
	private int orderId;
	
	@NotNull
	@Column(name = "order_date")
	private LocalDate orderDate;
	
	@NotNull
	@Column(name = "dispatch_Date")
	private LocalDate dispatchDate;
	
	@Column(name="cost",nullable=false)
	private int cost;
	
	@NotNull
	@Column(name = "total_Cost")
	private float totalCost;
	
	@NotNull
	@Column(name = "status")
	private String status;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@NotNull
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="medicineId",referencedColumnName="medicineId")
	private Medicine medicine;

	public Order() {
		super();
	}

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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public Order(@NotNull int orderId, @NotNull LocalDate orderDate, @NotNull LocalDate dispatchDate, int cost,
			@NotNull float totalCost, @NotNull String status, @NotNull Customer customer, Medicine medicine) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.dispatchDate = dispatchDate;
		this.cost = cost;
		this.totalCost = totalCost;
		this.status = status;
		this.customer = customer;
		this.medicine = medicine;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", dispatchDate=" + dispatchDate + ", cost="
				+ cost + ", totalCost=" + totalCost + ", status=" + status + ", customer=" + customer + ", medicine="
				+ medicine + "]";
	}

}
