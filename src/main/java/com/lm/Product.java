package com.lm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lm.price.Price;
import com.lm.price.PriceFactory;

public class Product {
    private String name;
    private Price price;

    public Product() {
        this.name = "empty";
        this.price = new Price();
    }

    public Product(String info) {
        // FIXME: it may be useful to check first
        // if regex is correct
        // \d+\s+([a-zA-Z]+(\s)+)*at\s\d+(\.)?\d+
        this.setPrice(info);
        this.setQuantityThroughInfo(info);
        this.setNameThroughInfo(info);
    }

    static public String formatNumber(double number) {
        return (String.format("%.02f", number)).replace(",", ".");
    }

    public String getName() {
        return this.name;
    }
    
    public String print() {
        return this.price.getQuantity() + " " + this.getName() + ": " + Product.formatNumber(this.price.getTotalPrice()) + "\n";
    }
    
    public Price getPrice() {
        return this.price;
    }

    private void setQuantityThroughInfo(String info) {
        this.price.setQuantity(Integer.valueOf(this.parseRegex(info, "^\\d+")));
    }

    private void setNameThroughInfo(String info) {
        this.name = this.parseRegex(info, "([a-zA-Z]+(\\s)+)*at");
        this.name = this.name.replaceAll(" at", "");
    }

    private void setPrice(String info) {
        PriceFactory priceFactory = new PriceFactory();
        this.price = priceFactory.getPrice(info);
        this.price.setPrice(Double.valueOf(this.parseRegex(info, "\\d+\\.\\d+")));
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
