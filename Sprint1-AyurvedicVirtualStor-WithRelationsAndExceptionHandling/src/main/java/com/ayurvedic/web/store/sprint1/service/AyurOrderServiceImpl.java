package com.ayurvedic.web.store.sprint1.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayurvedic.web.store.sprint1.entities.AyurOrder;
import com.ayurvedic.web.store.sprint1.exceptions.OrderNotPlacedException;
import com.ayurvedic.web.store.sprint1.repository.ICustomerRepository;
import com.ayurvedic.web.store.sprint1.repository.IAyurOrderRepository;


@Service
@Transactional
public class AyurOrderServiceImpl implements IAyurOrderService{
	
	@Autowired
	IAyurOrderRepository orderRepository;
	
	

	@Override
	public AyurOrder addOrder(AyurOrder order) {
		
		if(order.equals(null))
			 throw new OrderNotPlacedException();
		else
			return orderRepository.save(order);
	}

	@Override
	public AyurOrder updateOrder(AyurOrder order) {
		
		Optional<AyurOrder> orderUpdate = orderRepository.findById(order.getOrderId());
		if(orderUpdate.isPresent())
			orderRepository.save(order);
		
		return orderUpdate.orElseThrow(
				()->new OrderNotPlacedException("AyurOrder with the Id "+ order.getOrderId()+" is not found"));
	}

	@Override
	public AyurOrder updateOrderStatus(int orderId, String status) {
		
		Optional<AyurOrder> orderUpdateStatus = orderRepository.findById(orderId);
		
		if(orderUpdateStatus.isPresent()) {
				AyurOrder orderToUpdate = orderUpdateStatus.get();
				orderToUpdate.setStatus(status);
				return orderToUpdate;
				}
		
		return orderUpdateStatus.orElseThrow(()-> 
					new OrderNotPlacedException(" The Status cannot be updated as the AyurOrder-ID : "+orderId+" does not exist"));
	}

	@Override
	public AyurOrder cancelOrder(int orderId) {
		
		Optional<AyurOrder> orderToDelete  = orderRepository.findById(orderId);
		if (orderToDelete.isPresent()){
				AyurOrder deleteOrder = orderToDelete.get();
				orderRepository.delete(deleteOrder);
				return deleteOrder;
			}
		return orderToDelete.orElseThrow(()-> 
				new OrderNotPlacedException("AyurOrder with id :"+orderId+" never placed"));
	}

	@Override
	public double totalCost(int orderId,double cost) {
		
		Optional<AyurOrder> order = orderRepository.findById(orderId);
		 
		AyurOrder orderTotalCost = order.get();
		return orderTotalCost.getTotalCost();
		
	}

	@Override
	public AyurOrder showOrder(int orderId) {
		
		Optional<AyurOrder> showOrder = orderRepository.findById(orderId);
		if(showOrder.isPresent()) {
			AyurOrder showOrder1 = showOrder.get();
			return showOrder1;
		}
		
		return showOrder.orElseThrow(()-> 
					new OrderNotPlacedException("AyurOrder with id : "+orderId+" not found."));
	}

	/*@Override
	public List<AyurOrder> showOrderByCustomerId(int customerId) {
		
		List<AyurOrder> orderingCustomer = orderRepository.findAll();
		List<AyurOrder> orderingCustomerList = new ArrayList();

		AyurOrder orderCustomerId = new AyurOrder();
		Iterator it = orderingCustomer.listIterator();
		
		while(it.hasNext()) {
			orderCustomerId = (AyurOrder) it.next();
			if (orderCustomerId.getCustomer().getCutomerId() == customerId) {
					//int orderIdNeeded = orderCustomerId.getOrderId();
					orderingCustomerList.add(orderCustomerId);
				}
		}
		return orderingCustomerList;
	}*/

	@Override
	public List<AyurOrder> showAllOrders() {
		return orderRepository.findAll();
	}

}
