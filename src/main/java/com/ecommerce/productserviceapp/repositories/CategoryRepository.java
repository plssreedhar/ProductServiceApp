package com.ecommerce.productserviceapp.repositories;

import com.ecommerce.productserviceapp.models.Category;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByTitle(String name);

    @Override
    void deleteById(@NonNull Long categoryId);
}
