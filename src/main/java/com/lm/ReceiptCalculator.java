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
            output += product.getQuantity() + " " + product.getName() + ": "
                    + this.formatNumber(product.getTotalPrice()) + "\n";
            taxes += product.getTaxes();
            total += product.getTotalPrice();
        }
        output += "Sales Taxes: " + this.formatNumber(taxes) + "\n";
        output += "Total: " + this.formatNumber(total);
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

    private String formatNumber(double number) {
        return (String.format("%.02f", number)).replace(",", ".");
    }
}
