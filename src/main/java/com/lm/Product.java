package com.lm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {
    private static double IMPORTED_TAX = 0.05;
    private static double REGULAR_TAX = 0.1;

    private int quantity;
    private String name;
    private boolean imported;
    private boolean exempted;

    // FIXME: this is a different object
    private double price;
    private double taxes;

    // FIXME: this should be in a configuration file
    private static String exemptedList[] = { "chocolate", "headache pills", "book" };

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

    static public String formatNumber(double number) {
        return (String.format("%.02f", number)).replace(",", ".");
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
            this.taxes += this.getRoundedTaxes(IMPORTED_TAX);
        }
        if (!this.isExempted()) {
            this.taxes += this.getRoundedTaxes(REGULAR_TAX);
        }
    }

    public double getPrice() {
        return this.price;
    }

    public double getTotalPrice() {
        this.calculateTaxes();
        return (this.price + this.taxes);
    }

    public double getTaxes() {
        return this.taxes;
    }

    public String print() {
        return this.getQuantity() + " " + this.getName() + ": " + this.formatNumber(this.getTotalPrice()) + "\n";
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

    private double getRoundedTaxes(double taxPercentage) {
        return (double) Math.round(this.price * taxPercentage * 100d) / 100d;
    }
}
