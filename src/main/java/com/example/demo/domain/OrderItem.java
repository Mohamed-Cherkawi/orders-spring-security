package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull @NotEmpty @ManyToOne
    private Product product;
    @NotNull
    private Integer quantity;
    @NotNull(message = "price is mandatory")
    private Double price;

    @ManyToOne
    private Order order;

}
