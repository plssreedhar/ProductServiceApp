package com.ecommerce.productserviceapp.repositories;

import com.ecommerce.productserviceapp.models.Category;
import com.ecommerce.productserviceapp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategory(Category category);
 }
