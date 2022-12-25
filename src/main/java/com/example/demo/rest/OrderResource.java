package com.example.demo.rest;

import com.example.demo.domain.Order;
import com.example.demo.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@RestController @AllArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderResource {

    OrderService orderService;

    @GetMapping("/")
    public List<Order> showAllOrders(){
       return orderService.getAllOrders();
    }
    @PostMapping("/new") @ResponseBody
    public Order save(@RequestBody @Valid Order order) {
        return orderService.save(order);
    }

}