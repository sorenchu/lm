package com.lm;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BasicInputTest extends TestCase {
    public BasicInputTest(String testName) {
        super(testName);
    }

    public void testInputOne() {
        String input1 = "1 book at 12.49\n" + "1 music CD at 14.99\n" + "1 chocolate bar at 0.85";
        ReceiptCalculator receiptCalculator = new ReceiptCalculator(input1);
        String output = receiptCalculator.execute();
        assertEquals("1 book: 12.49\n" + "1 music CD: 16.49\n" + "1 chocolate bar: 0.85\n" + "Sales Taxes: 1.50\n"
                + "Total: 29.83", output);
    }

    public void testInputTwo() {
        String input1 = "1 imported box of chocolates at 10.00\n" + "1 imported bottle of perfume at 47.50";
        ReceiptCalculator receiptCalculator = new ReceiptCalculator(input1);
        String output = receiptCalculator.execute();
        assertEquals("1 imported box of chocolates: 10.50\n" + "1 imported bottle of perfume: 54.65\n"
                + "Sales Taxes: 7.65\n" + "Total: 65.15", output);
    }

    public void testInputThree() {
        String input1 = "1 imported bottle of perfume at 27.99\n" + "1 bottle of perfume at 18.99\n"
                + "1 packet of headache pills at 9.75\n" + "1 box of imported chocolates at 11.25";
        ReceiptCalculator receiptCalculator = new ReceiptCalculator(input1);
        String output = receiptCalculator.execute();
        assertEquals("1 imported bottle of perfume: 32.19\n" + "1 bottle of perfume: 20.89\n"
                + "1 packet of headache pills: 9.75\n" + "1 imported box of chocolates: 11.85\n" + "Sales Taxes: 6.70\n"
                + "Total: 74.68\n", output);
    }

    public static Test suite() {
        return new TestSuite(BasicInputTest.class);
    }
}
