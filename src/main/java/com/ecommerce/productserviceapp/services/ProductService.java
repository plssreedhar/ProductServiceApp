package com.ecommerce.productserviceapp.services;

import com.ecommerce.productserviceapp.exceptions.CategoryNotFoundException;
import com.ecommerce.productserviceapp.exceptions.ProductNotFoundException;
import com.ecommerce.productserviceapp.exceptions.ValidationException;
import com.ecommerce.productserviceapp.models.Category;
import com.ecommerce.productserviceapp.models.Product;
import com.ecommerce.productserviceapp.repositories.CategoryRepository;
import com.ecommerce.productserviceapp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Product> getAllProductsByCategory(String categoryName) throws CategoryNotFoundException {
        Optional<Category> category = categoryRepository.findByTitle(categoryName);
        if(category.isEmpty()){
            throw new CategoryNotFoundException("Category not found: " + categoryName);
        }
        return productRepository.findAllByCategory(category.get());
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


    public Product createProduct(Product product) {
       return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(Long productId) {
        if (productId == null || productId <= 0) {
            throw new ValidationException("Invalid product ID: " + productId);
        }

        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + productId));
    }
}
