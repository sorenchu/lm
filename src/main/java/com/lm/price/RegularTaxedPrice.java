package com.lm.price;

public class RegularTaxedPrice extends Price {
    private static double IMPORTED_TAX = 0.1;

    @Override
    public double getRoundedTaxes() {
        return (double) Math.round(this.price * IMPORTED_TAX * 100d) / 100d;
    }
}
