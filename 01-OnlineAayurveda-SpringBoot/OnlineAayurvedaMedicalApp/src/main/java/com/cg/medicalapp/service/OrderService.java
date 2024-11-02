package com.cg.medicalapp.service;


import java.util.List;

import com.cg.medicalapp.entity.Order;
import com.cg.medicalapp.exception.RecordNotFoundException;


public interface OrderService {
	
	public Order addOrder(int cartId, int medicineId) throws RecordNotFoundException;
	public Order updateOrder(int id, Order order) throws RecordNotFoundException;
	public Order updateOrderStatus(int id, String status) throws RecordNotFoundException;
	public Order cancelOrder(int id) throws RecordNotFoundException;
	public int calculateTotalCost(int cost);
	public Order showOrder(int id) throws RecordNotFoundException;
	public List<Order> showAllOrders();
	public List<Order> showOrderByCustomer(int id) throws RecordNotFoundException;

}