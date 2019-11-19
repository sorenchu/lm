package com.lm;

import java.util.ArrayList;

public class ReceiptCalculator {
    private String content;
    private ArrayList<Product> products;

    public ReceiptCalculator(String filecontent) {
        content = filecontent;
        this.parseInput();
    }

    public String execute() {
        String output = "";
        double taxes = 0;
        double total = 0;
        for (Product product : this.products) {
            output += product.getQuantity() + " " + 
                    product.getName() + ": " + product.getTotalPrice() + "\n";
            taxes += product.getTaxes();
            total += product.getTotalPrice();
        }
        output += "Sales Taxes: " + taxes + "\n";
        output += "Total: " + total;
        return output;
    }
    
    private void parseInput() {
        this.products = new ArrayList<Product>();
        String[] lines = this.content.split("\n");
        for (String line : lines) {
            this.products.add(new Product(line));
        }
    }

    public int getProductSize() {
        return products.size();
    }
}
