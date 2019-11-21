package com.lm.price;

public class Price {
    private int quantity;
    protected double price;

    public Price() {
        this.quantity = 0;
        this.price = 0;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double calculateTaxes() {
        return this.quantity * this.getRoundedTaxes();
    }

    public double getTotalPrice() {
        return (double) Math.round(((this.quantity * this.price) + this.calculateTaxes()) * 100d) / 100d;
    }

    public double getRoundedTaxes() {
        return 0;
    }

}
