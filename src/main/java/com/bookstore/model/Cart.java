package com.bookstore.model;

import java.util.*;

public class Cart {

    private int customerId;
    private Map<Integer, Integer> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    public Cart(int customerId) {
        this();
        this.customerId = customerId;
    }

    public int getCustomerId() {return customerId;}
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Map<Integer, Integer> getItems() {return items;}
    public void setItems(Map<Integer, Integer> items) {
        this.items = items;
    }
}
