// File: src/test/java/com/ecommerce/productserviceapp/services/ProductServiceTest.java
package com.ecommerce.productserviceapp.services;

import com.ecommerce.productserviceapp.exceptions.CategoryNotFoundException;
import com.ecommerce.productserviceapp.exceptions.ProductNotFoundException;
import com.ecommerce.productserviceapp.exceptions.ValidationException;
import com.ecommerce.productserviceapp.models.Category;
import com.ecommerce.productserviceapp.models.Product;
import com.ecommerce.productserviceapp.repositories.CategoryRepository;
import com.ecommerce.productserviceapp.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProductsByCategory_CategoryExists() {
        String categoryName = "Electronics";
        Category category = new Category( categoryName );
        Product product = new Product(10000.0, "Laptop", "A laptop from HP","", category);

        when(categoryRepository.findByTitle(categoryName)).thenReturn(Optional.of(category));
        when(productRepository.findAllByCategory(category)).thenReturn(List.of(product));

        List<Product> products = productService.getAllProductsByCategory(categoryName);

        assertNotNull(products);
        assertEquals(1, products.size());
        assertEquals("Laptop", products.get(0).getTitle());
    }

    @Test
    void testGetAllProductsByCategory_CategoryNotFound() {
        String categoryName = "NonExistent";

        when(categoryRepository.findByTitle(categoryName)).thenReturn(Optional.empty());

        assertThrows(CategoryNotFoundException.class, () -> productService.getAllProductsByCategory(categoryName));
    }

    @Test
    void testGetProductById_ProductExists() {
        Long productId = 1L;
    Product product = new Product(10000.0, "Laptop", "A laptop from HP","", new Category("Electronics"));

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        Product result = productService.getProductById(productId);

        assertNotNull(result);
        assertEquals("Laptop", result.getTitle());
    }

    @Test
    void testGetProductById_ProductNotFound() {
        Long productId = 1L;

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () -> productService.getProductById(productId));
    }

    @Test
    void testGetProductById_InvalidProductId() {
        Long productId = -1L;

        assertThrows(ValidationException.class, () -> productService.getProductById(productId));
    }

    @Test
    void testCreateProduct() {
        Product product = new Product(10000.0, "Laptop", "A laptop from HP","", new Category("Electronics"));

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.createProduct(product);

        assertNotNull(result);
        assertEquals("Laptop", result.getTitle());
    }

    @Test
    void testDeleteProduct() {
        Long productId = 1L;

        doNothing().when(productRepository).deleteById(productId);

        productService.deleteProduct(productId);

        verify(productRepository, times(1)).deleteById(productId);
    }
}