package com.example.demo.rest;



import com.example.demo.domain.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;



import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/orders")
public class CommandeResource {

    @Autowired
    OrderService orderService;

    @PostMapping("/") @ResponseBody
    public Order save(@RequestBody @Valid Order order) {
        return orderService.save(order);
    }

}