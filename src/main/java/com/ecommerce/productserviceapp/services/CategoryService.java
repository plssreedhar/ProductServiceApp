package com.ecommerce.productserviceapp.services;

import com.ecommerce.productserviceapp.exceptions.ValidationException;
import com.ecommerce.productserviceapp.models.Category;
import com.ecommerce.productserviceapp.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    public Category getCategory(Long categoryId) {
        if (categoryId == null || categoryId <= 0) {
            throw new ValidationException("Invalid category ID: " + categoryId);
        }
        return categoryRepository.findById(categoryId).orElse(null);
    }

    public Category addCategory(String title) {
        Category category = new Category(title);
        return categoryRepository.save(category);
    }

    public void editCategory(Category category) {
        categoryRepository.save(category);
    }
}
