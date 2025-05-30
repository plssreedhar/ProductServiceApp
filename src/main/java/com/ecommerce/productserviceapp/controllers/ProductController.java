package com.ecommerce.productserviceapp.controllers;

import com.ecommerce.productserviceapp.exceptions.CategoryNotFoundException;
import com.ecommerce.productserviceapp.models.Product;
import com.ecommerce.productserviceapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/category/{categoryName}")
    public List<Product> getAllProductsOfCategory(@PathVariable("categoryName") String categoryName) {
        return productService.getAllProductsByCategory(categoryName);
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) throws CategoryNotFoundException {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long productId) {
        Product product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

}
