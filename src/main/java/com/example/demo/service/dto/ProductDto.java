package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private float price;
    private int quantity;
}
