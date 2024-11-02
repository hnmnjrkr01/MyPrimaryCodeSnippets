package com.cg.medicalapp.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.medicalapp.entity.Cart;
import com.cg.medicalapp.entity.Customer;
import com.cg.medicalapp.entity.Medicine;
import com.cg.medicalapp.entity.Order;
import com.cg.medicalapp.exception.RecordNotFoundException;
import com.cg.medicalapp.repository.CartRepository;
import com.cg.medicalapp.repository.CustomerRepository;
import com.cg.medicalapp.repository.MedicineRepository;
import com.cg.medicalapp.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private MedicineRepository medicineRepository;
	
	@Autowired
	private CartService cartService;
	
	@Override
	public Order addOrder(int cartId,int medicineId) throws RecordNotFoundException {
		Optional<Cart> c=cartRepository.findById(cartId);
		if(c.isPresent()) {
			Cart cart=c.get();
			Optional<Medicine> opt=medicineRepository.findById(medicineId);
			if(opt.isPresent()) {
				Medicine medicine=opt.get();
				if(cart.getmedicines().contains(medicine)) {
					int cost=(int)medicine.getMedicineCost();
					int totalCost=cost+20;
					Customer cust=cart.getCustomer();
					Medicine med=opt.get();
					Order order=new Order();
					order.setOrderDate(LocalDate.now());
					order.setDispatchDate(LocalDate.now().plusDays(1));
					order.setCost(cost);
					order.setTotalCost(totalCost);
					order.setStatus("Ordered");
					order.setCustomer(cust);
					order.setMedicine(med);
					orderRepository.save(order);
					cartService.deleteMedicine(cartId,medicineId);
					cartRepository.save(cart);
					return order;
				} else {
					throw new RecordNotFoundException("No medicine found with given medicine Id in the cart");
				}
			} else {
				throw new RecordNotFoundException("No medicine found with given medicine Id");
			}
			
		} else {
			String s="Cart not found with id "+cartId;
		    throw new RecordNotFoundException(s);
	    }
	}

	@Override
	public Order updateOrder(int id,Order order) throws RecordNotFoundException {
		Optional<Order> opt=orderRepository.findById(id);
		if(opt.isPresent()) {
			Order existingOrder=opt.get();
			existingOrder.setOrderDate(order.getOrderDate());
			existingOrder.setDispatchDate(order.getDispatchDate());
			existingOrder.setCost(order.getCost());
			existingOrder.setTotalCost(order.getTotalCost());
			existingOrder.setCustomer(order.getCustomer());
			existingOrder.setMedicine(order.getMedicine());
			orderRepository.save(existingOrder);
			return existingOrder;
		} else {
			throw new RecordNotFoundException("No order found with given order id");
		}
	}
	
	@Override
	public Order updateOrderStatus(int id, String status) throws RecordNotFoundException{
		Optional<Order> opt=orderRepository.findById(id);
		if(opt.isPresent()) {
			Order order=opt.get();
			order.setStatus(status);
			orderRepository.save(order);
			return order;
		} else {
			throw new RecordNotFoundException("No order found with given order id");
		}
	}
	

	@Override
	public Order cancelOrder(int id) throws RecordNotFoundException {
		Optional<Order> opt=orderRepository.findById(id);
		if(opt.isPresent()) {
			Order order=opt.get();
			order.setStatus("Cancelled");
			//orderRepository.deleteById(id);
			
			updateOrderStatus( id, "Cancelled");
			
			return order;
			
		} else {
			throw new RecordNotFoundException("No order found with given order id");
		}
	}

	@Override
	public int calculateTotalCost(int cost) {
		int totalCost, serviceCharges=20;
		totalCost=cost+(serviceCharges);
		return totalCost;
	}
	
	@Override
	public Order showOrder(int id) throws RecordNotFoundException {
		Optional<Order> opt=orderRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		} else {
			throw new RecordNotFoundException("No order found with given order id");
		}
	}
	
	@Override
	public List<Order> showOrderByCustomer(int id) throws RecordNotFoundException{
		Optional<Customer> opt=customerRepository.findById(id);
		if(opt.isPresent()) {
			return orderRepository.findByCustomer(id);
		} else {
			throw new RecordNotFoundException("No customer found with given id");
		}
	}
	
	@Override
	public List<Order> showAllOrders(){
		return (List<Order>) orderRepository.findAll();
	}

}