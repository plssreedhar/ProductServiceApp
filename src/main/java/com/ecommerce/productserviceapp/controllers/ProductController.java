package com.ecommerce.productserviceapp.controllers;

import com.ecommerce.productserviceapp.models.Product;
import com.ecommerce.productserviceapp.repositories.ProductRepository;
import com.ecommerce.productserviceapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/category/{categoryName}")
    public List<Product> getAllProductsOfCategory(@PathVariable("categoryName") String categoryName){
        return productService.getAllProductsByCategory(categoryName);
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
