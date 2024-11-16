package com.IIT2ndyr.EventTicketSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    @Column(unique = true)
    private String email;

    private String mobileNumber;

    @Enumerated(EnumType.STRING)
    private CustomerLevel customerLevel; // NORMAL or VIP

    @ElementCollection
    private List<Long> purchasedTickets; // List of ticket IDs purchased by the customer

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public CustomerLevel getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(CustomerLevel customerLevel) {
        this.customerLevel = customerLevel;
    }

    public List<Long> getPurchasedTickets() {
        return purchasedTickets;
    }

    public void setPurchasedTickets(List<Long> purchasedTickets) {
        this.purchasedTickets = purchasedTickets;
    }
}

enum CustomerLevel {
    NORMAL,
    VIP
}