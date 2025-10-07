package com.camillyPessotti.productsApi.repository;

import com.camillyPessotti.productsApi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
