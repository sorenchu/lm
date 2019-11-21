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
        assertEquals(1, product.getPrice().getQuantity());
        assertEquals("book", product.getName());
        assertEquals(12.49, product.getPrice().getTotalPrice());
    }

    public void testCreationFromTwoWordsProductLine() {
        Product product = new Product("1 music CD at 14.99");
        assertEquals(1, product.getPrice().getQuantity());
        assertEquals("music CD", product.getName());
        assertEquals(16.49, product.getPrice().getTotalPrice());
    }

    public void testCreationFromTwoWordsProductsLine() {
        Product product = new Product("3 music CDs at 14.99");
        assertEquals(3, product.getPrice().getQuantity());
        assertEquals("music CDs", product.getName());
        assertEquals(49.47, product.getPrice().getTotalPrice());
    }

    public void testCreationSeveralWordsImported() {
        Product product = new Product("1 imported box of chocolates at 10.00");
        assertEquals(1, product.getPrice().getQuantity());
        assertEquals("imported box of chocolates", product.getName());
        assertEquals(10.5, product.getPrice().getTotalPrice());
    }

    public static Test suite() {
        return new TestSuite(ProductTest.class);
    }
}
