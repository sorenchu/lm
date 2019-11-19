package com.lm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {
    private int quantity;
    private String name;
    private boolean imported;
    private boolean exempted;
    private double price;
    private double taxes;

    private String exemptedList[] = { "chocolate", "headache pills", "book" };

    public Product() {
        this.quantity = 0;
        this.name = "empty";
        this.imported = false;
        this.exempted = false;
        this.price = 0.0;
        this.taxes = 0.0;
    }

    public Product(String info) {
        // FIXME: it may be useful to check first
        // if regex is correct
        // \d+\s+([a-zA-Z]+(\s)+)*at\s\d+(\.)?\d+
        this.setQuantityThroughInfo(info);
        this.setNameThroughInfo(info);
        this.setImported();
        this.setExepmted();
        this.setPrice(info);
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

    public boolean isExempted() {
        return this.exempted;
    }

    public void calculateTaxes() {
        this.taxes = 0;
        if (this.isImported()) {
            this.taxes += 0.05 * this.price;
        }
        if (!this.isExempted()) {
            this.taxes += 0.10 * this.price;
        }
    }

    public double getPrice() {
        return this.price;
    }

    public double getTotalPrice() {
        this.calculateTaxes();
        return (this.taxes + this.price);
    }

    public double getTaxes() {
        return this.taxes;
    }

    private void setQuantityThroughInfo(String info) {
        this.quantity = Integer.valueOf(this.parseRegex(info, "^\\d+"));
    }

    private void setNameThroughInfo(String info) {
        this.name = this.parseRegex(info, "([a-zA-Z]+(\\s)+)*at");
        this.name = this.name.replaceAll(" at", "");
    }

    private void setImported() {
        // FIXME: think if "imported" can have a capitalized letter
        this.imported = name.contains("imported");
    }

    private void setPrice(String info) {
        this.price = Double.valueOf(this.parseRegex(info, "\\d+\\.\\d+"));
    }

    private void setExepmted() {
        for (String keyword : this.exemptedList) {
            if (name.contains(keyword)) {
                this.exempted = true;
                return;
            }
        }
    }

    private String parseRegex(String info, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(info);
        String value = "";
        while (matcher.find()) {
            value = matcher.group();
        }
        return value;
    }

}
