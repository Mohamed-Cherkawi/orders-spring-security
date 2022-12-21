package com.example.demo.service.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private float price;
    private int quantity;
}
