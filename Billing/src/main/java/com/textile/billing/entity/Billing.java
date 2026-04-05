package com.textile.billing.entity;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billingId;
    private int noOfProduct;
    private double totalAmount;
    // Many bills belong to one customer
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Many products in one bill
    @ManyToMany
    @JoinTable(
            name = "billing_product",
            joinColumns = @JoinColumn(name = "billing_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public void setCustomer(Customer customer) {
    }

    public void setProducts(List<Product> products) {
    }

    public void setNoOfProduct(int size) {
    }

    public void setTotalAmount(double total) {
    }

    // Getters and Setters
}