package com.ecommerce.productserviceapp.controllers;

import com.ecommerce.productserviceapp.models.Category;
import com.ecommerce.productserviceapp.services.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Long categoryId) {
       return categoryService.getCategory(categoryId);
    }

    @PostMapping("/")
    public Category addCategory(@RequestParam("title") String title){
        return categoryService.addCategory(title);
    }

    @PutMapping("/")
    public Category addCategory(@RequestBody Category category){
        return categoryService.editCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
