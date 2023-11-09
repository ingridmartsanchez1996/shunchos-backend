package com.shuncosdb.shuncosdb.service;

import com.shuncosdb.shuncosdb.model.Order;
import com.shuncosdb.shuncosdb.model.User;
import com.shuncosdb.shuncosdb.repository.OrderRepository;
import com.shuncosdb.shuncosdb.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    // Get all products
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get one order by Id
    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    //Post
	public Order createOrder(HashMap<String, Object> json) {		
    	Order order = new Order();
    	Calendar today = Calendar.getInstance();

        order.setCreate_at(today.getTime());
        order.setStatus(((Number)json.get("status")).longValue());
        order.setSubtotal_price((Double)json.get("subtotal_price"));
        order.setHas_coupon((Boolean)json.get("has_coupon"));

        if ((Boolean)json.get("has_coupon")) {
            order.setCoupon_text((String)json.get("coupon_text"));
            order.setDiscount_applied((Double)json.get("discount_applied"));
            order.setCoupon_percentage((Double)json.get("coupon_percentage"));
        }
        order.setShipment_price((Double)json.get("shipment_price"));
        order.setTotal_price((Double)json.get("total_price"));

        //agregando address
        order.addAddress(json);

        //agregando payment
        order.addPayment(json);

        //agregando usuario a la orden
        User usr = userRepository.findById(((Number)json.get("user_id")).longValue()).orElse(null);
        order.setUser(usr);
        //usr.getOrder().add(order);
        //userRepository.save(usr);

        //agregar producto
        //order.addProduct(json)

		return orderRepository.save(order);
	}
}
