package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private String category;
    private String description;
    private BigDecimal discount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name.length() >= 3 && name.length() <= 32) {
            this.name = name;
        } else {
            throw new Exception("The name cannot be shorter than 3 symbols or longer than 32 symbols");
        }
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) throws Exception {
        if (price.signum() == 1) {
            this.price = price;
        } else {
            throw new Exception("Price must be nonzero positive");
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) throws Exception {
        if (discount.compareTo(price) <= 0) {
            this.discount = discount;
        } else {
            throw new Exception("The discount cannot exceed the price");
        }

    }
}