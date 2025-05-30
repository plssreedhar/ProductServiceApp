package com.ecommerce.productserviceapp.services;

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

    public List<Product> getAllProductsByCategory(String categoryName){
        Optional<Category> category = categoryRepository.findByTitle(categoryName);
        if(category.isEmpty()){
            return Collections.emptyList();
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
}
