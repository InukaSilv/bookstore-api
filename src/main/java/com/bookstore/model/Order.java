package com.bookstore.model;

import java.util.*;
import java.time.LocalDateTime;

public class Order {

    private int id;
    private int customerId;
    private LocalDateTime orderDate;
    private Map<Integer, Integer> items;
    private double totalAmount;

    public Order() {
        this.items = new HashMap<>();
        this.orderDate = LocalDateTime.now();
    }

    public Order(int id, int customerId) {
        this();
        this.id = id;
        this.customerId = customerId;
    }

    public int getId() {return id;}
    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {return customerId;}
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getOrderDate() {return orderDate;}
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Map<Integer, Integer> getItems() {return items;}
    public void setItems(Map<Integer, Integer> items) {
        this.items = items;
    }

    public double getTotalAmount() {return totalAmount;}
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
