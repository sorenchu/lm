package com.lm;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ProductTest extends TestCase {
    public ProductTest(String testName) {
        super(testName);
    }

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
    
    public static Test suite() {
        return new TestSuite(ProductTest.class);
    }
}
