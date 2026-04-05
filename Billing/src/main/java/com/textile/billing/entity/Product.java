package com.textile.billing.entity;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String productName;
    private double price;

    @ManyToMany(mappedBy = "products")
    private List<Billing> billings;

    public double getPrice() {
        return price;
    }

    // Getters and Setters
}