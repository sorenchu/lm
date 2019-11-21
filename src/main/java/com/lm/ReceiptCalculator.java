package com.lm;

import java.util.ArrayList;

public class ReceiptCalculator {
    private ArrayList<Product> products;

    public ReceiptCalculator(String filecontent) {
        this.parseInput(filecontent);
    }

    public String execute() {
        String output = "";
        double taxes = 0;
        double total = 0;
        for (Product product : this.products) {
            output += product.print();
            taxes += product.getPrice().calculateTaxes();
            total += product.getPrice().getTotalPrice();
        }
        output += "Sales Taxes: " + Product.formatNumber(taxes) + "\n";
        output += "Total: " + Product.formatNumber(total);
        return output;
    }

    public int getProductSize() {
        return products.size();
    }

    private void parseInput(String content) {
        this.products = new ArrayList<Product>();
        String[] lines = content.split("\n");
        for (String line : lines) {
            this.products.add(new Product(line));
        }
    }
}
