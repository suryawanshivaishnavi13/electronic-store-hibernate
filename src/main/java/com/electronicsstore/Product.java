package com.electronicsstore;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;

    private double price;

    private LocalDate expiryDate;

    // Constructors
    public Product() {
    }

    public Product(String productName, double price, LocalDate expiryDate) {
        this.productName = productName;
        this.price       = price;
        this.expiryDate  = expiryDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate newExpiryDate) {
        this.expiryDate = newExpiryDate;
    }

    @Override
    public String toString() {
        return "Product{id='" + id + "' , productName='" + productName + "' , price='" + price  + "' , expiryDate='" + expiryDate + "'}";
    }
}