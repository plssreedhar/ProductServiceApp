package com.ecommerce.productserviceapp.models;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private Double price;
    private String description;
    private String imageUrl;
    private Category category;
}
