package com.lm.price;

public class PriceFactory {
    // FIXME: this should be in a configuration file
    private static String EXEMPTEDLIST[] = { "chocolate", "headache pills", "book" };

    public Price getPrice(String info) {
        boolean isExempted = false;
        for (String keyword : EXEMPTEDLIST) {
            if (info.contains(keyword)) {
                isExempted = true;
            }
        }
        if (info.contains("imported")) {
            return isExempted ? new ImportedPrice() : new ImportedTaxedPrice();
        } else {
            return isExempted ? new Price() : new RegularTaxedPrice();
        }
    }
}
