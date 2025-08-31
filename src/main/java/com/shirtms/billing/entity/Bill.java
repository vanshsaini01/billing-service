package com.shirtms.billing.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private Double amount;

    private LocalDate date;

    // --- Constructors ---
    public Bill() {
    }

    public Bill(String customerName, Double amount, LocalDate date) {
        this.customerName = customerName;
        this.amount = amount;
        this.date = date;
    }

    // --- Lifecycle Hook to auto-set date before persisting ---
    @PrePersist
    protected void onCreate() {
        if (this.date == null) {
            this.date = LocalDate.now();  // Automatically set today's date
        }
    }

    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
