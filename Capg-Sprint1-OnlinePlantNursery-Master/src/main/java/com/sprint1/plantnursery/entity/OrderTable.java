package com.sprint1.plantnursery.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*Controller Class for Order Controller
Created By: Sakshi Shah
*/

@Entity
@Table(name = "ordertable")
public class OrderTable {
	@Id
	@GeneratedValue
	private Integer bookingId;
	private LocalDate orderDate;
	private String transactionMode;
	private int quantity;
	private double price;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	private Planter planter;
	
	public OrderTable() {

	}

	public Integer getBookingOrderId() {
		return bookingId;
	}

	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingId = bookingOrderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [bookingId=" + bookingId + ", bookingDate=" + orderDate + ", transactionMode=" + transactionMode
				+ ",price=" + price + "]";
	}
}
