package com.ecommerce.productserviceapp.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "products")
public class Product extends BaseModel {
    private Double price;
    private String description;
    private String imageUrl;
    private Category category;
}
