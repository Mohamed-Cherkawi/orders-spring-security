package com.example.demo.service;


import com.example.demo.domain.Order;
import com.example.demo.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service @AllArgsConstructor
public class OrderService {
    OrderRepository orderRepository;
    OrderItemService orderItemService;


    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    public Order save(Order order){
        order.setUuid(UUID.randomUUID());
        order.setCreatedAt(LocalDateTime.now());
        order =  orderRepository.save(order);
        Order finalOrder = order;
        order.getOrderItems().forEach(orderItem -> {
            orderItem.setOrder(finalOrder);
            orderItemService.save(orderItem);
        });
        return order;

    }
}
