package com.lm;

import junit.framework.TestCase;

public class ProductTest extends TestCase {
    public void testCreationFromOneWordProductLine() {
        Product product = new Product("1 book at 12.49");
        assertEquals(product.getQuantity(), 1);
        assertEquals(product.getName(), "book");
        assertEquals(product.getPrice(), 12.49);
        assertFalse(product.isImported());
    }
    
    public void testCreationFromTwoWordsProductLine() {
        Product product = new Product("1 music CD at 14.99");
        assertEquals(product.getQuantity(), 1);
        assertEquals(product.getName(), "music CD");
        assertEquals(product.getPrice(), 14.99);
        assertFalse(product.isImported());
    }
}
