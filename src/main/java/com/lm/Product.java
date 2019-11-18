package com.lm;

public class Product {
    private int quantity;
    private String name;
    private boolean imported;
    private double price;
    
    public Product(String info) {
        // \d+\s+([a-zA-Z]+(\s)+)*at\s\d+(\.)?\d+
        this.quantity = 0;
        this.name = "patata";
        this.imported = false;
        this.price = 0.0;
    }
    
    public int getQuantity() {
        return this.quantity;
    }

    public String getName() {
        return this.name;
    }

    public boolean isImported() {
        return this.imported;
    }
    
    public double getPrice() {
        return this.price;
    }
}
