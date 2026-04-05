package com.textile.billing.entity;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String customerName;
    private String location;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Billing> billings;

    // Getters and Setters
}