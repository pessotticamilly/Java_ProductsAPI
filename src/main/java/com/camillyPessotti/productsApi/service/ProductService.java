package com.camillyPessotti.productsApi.service;

import com.camillyPessotti.productsApi.dto.ProductResponseDTO;
import com.camillyPessotti.productsApi.model.Category;
import com.camillyPessotti.productsApi.model.Product;
import com.camillyPessotti.productsApi.repository.CategoryRepository;
import com.camillyPessotti.productsApi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    private ProductResponseDTO toDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getRegistrationDate(),
                product.getCategory() != null ? product.getCategory().getId() : null,
                product.getCategory() != null ? product.getCategory().getName() : null
        );
    }

    public List<ProductResponseDTO> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return toDTO(product);
    }

    public List<ProductResponseDTO> getProductByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ProductResponseDTO createProduct(Product product) {
        Category category = categoryRepository.findById(product.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Invalid category"));
        product.setCategory(category);

        Product saved = productRepository.save(product);
        return toDTO(saved);
    }

    public ProductResponseDTO updateProduct(Long id, Product newProduct) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(newProduct.getName());
        product.setDescription(newProduct.getDescription());
        product.setPrice(newProduct.getPrice());

        Category category = categoryRepository.findById(newProduct.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Invalid category"));
        product.setCategory(category);

        Product updated = productRepository.save(product);
        return toDTO(updated);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }
}