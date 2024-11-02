package com.ayurvedic.web.store.sprint1.service;

import java.util.List;

import com.ayurvedic.web.store.sprint1.entities.AyurOrder;

public interface IAyurOrderService {
	public AyurOrder addOrder(AyurOrder order);
	public AyurOrder updateOrder(AyurOrder order);
	public AyurOrder updateOrderStatus(int orderId, String status);
	public AyurOrder cancelOrder(int orderId);
	public double totalCost(double cost);
	public AyurOrder showOrder(int orderId);
	//public List<Order> showOrderByCustomerId(int customerId);	
	public List<AyurOrder> showAllOrders();
}
