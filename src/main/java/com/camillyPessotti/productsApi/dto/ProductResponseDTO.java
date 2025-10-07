package com.camillyPessotti.productsApi.dto;

import java.time.LocalDateTime;

public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private LocalDateTime registrationDate;
    private Long categoryId;
    private String categoryName;

    public ProductResponseDTO(Long id, String name, String description, Double price, LocalDateTime registrationDate, Long categoryId, String categoryName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.registrationDate = registrationDate;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public Double getPrice() { return price; }

    public LocalDateTime getRegistrationDate() { return registrationDate; }

    public Long getCategoryId() { return categoryId; }

    public String getCategoryName() { return categoryName; }
}
