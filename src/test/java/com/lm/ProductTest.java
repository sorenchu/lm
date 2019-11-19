package com.lm;

import junit.framework.TestCase;

public class ProductTest extends TestCase {
    public void testCreationFromOneWordProductLine() {
        Product product = new Product("1 book at 12.49");
        assertEquals(1, product.getQuantity());
        assertEquals("book", product.getName());
        assertEquals(12.49, product.getPrice());
        assertFalse(product.isImported());
    }

    public void testCreationFromTwoWordsProductLine() {
        Product product = new Product("1 music CD at 14.99");
        assertEquals(1, product.getQuantity());
        assertEquals("music CD", product.getName());
        assertEquals(14.99, product.getPrice());
        assertFalse(product.isImported());
    }
}
