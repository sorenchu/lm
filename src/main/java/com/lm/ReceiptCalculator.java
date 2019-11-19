package com.lm;

import java.util.ArrayList;

public class ReceiptCalculator {
    private String content;
    private ArrayList<Product> products;

    public ReceiptCalculator(String filecontent) {
        content = filecontent;
    }

    public String execute() {
        String output = "patata";
        return output;
    }
    
    private void ParseInput() {
        String[] lines = this.content.split("\n");
        for (String line : lines) {
            this.products.add(new Product(line));
        }
    }

    public int getProductSize() {
        return products.size();
    }
}
