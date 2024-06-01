package com.e.web.commerce.dto;


import lombok.Data;

@Data
public class ProductRequestDto {
    private String name;
    private String description;
    private int quantity;
    private double price;
    private Long category;
}
