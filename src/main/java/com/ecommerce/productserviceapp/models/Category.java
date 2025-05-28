package com.ecommerce.productserviceapp.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseModel {
    private String title;
}
