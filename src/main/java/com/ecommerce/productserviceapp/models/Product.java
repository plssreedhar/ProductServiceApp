package com.ecommerce.productserviceapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "products")
@NoArgsConstructor
public class Product extends BaseModel {
    private Double price;
    private String title;
    private String description;
    private String imageUrl;
    @ManyToOne(fetch = jakarta.persistence.FetchType.EAGER, cascade = jakarta.persistence.CascadeType.ALL)
    private Category category;

    public Product(Double price, String title, String description, String imageUrl,Category category) {
        this.price = price;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
    }
}
