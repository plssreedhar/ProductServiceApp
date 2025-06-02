package com.ecommerce.productserviceapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "categories")
@NoArgsConstructor
public class Category extends BaseModel {
    private String title;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = jakarta.persistence.CascadeType.ALL)
    private List<Product> products;
    public Category(String title) {
        this.title = title;
    }
}
