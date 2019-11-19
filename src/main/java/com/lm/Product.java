package com.lm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {
    private int quantity;
    private String name;
    private boolean imported;
    private double price;

    public Product() {
        this.quantity = 0;
        this.name = "empty";
        this.imported = false;
        this.price = 0.0;
    }

    public Product(String info) {
        // FIXME: it may be useful to check first
        // if regex is correct
        // \d+\s+([a-zA-Z]+(\s)+)*at\s\d+(\.)?\d+
        this.setQuantityThroughInfo(info);
        this.setNameThroughInfo(info);
        this.setImported();
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

    public double getPrice() {
        return this.price;
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
