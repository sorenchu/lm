package com.lm;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ReceiptCalculatorTest extends TestCase {
    public ReceiptCalculatorTest(String testName) {
        super(testName);
    }

    public void testProductCreation() {
        String input1 = "1 book at 12.49\n" + "1 music CD at 14.99\n" + "1 chocolate bar at 0.85";
        ReceiptCalculator receiptCalculator = new ReceiptCalculator(input1);
        assertEquals(3, receiptCalculator.getProductSize());
    }

    public static Test suite() {
        return new TestSuite(ReceiptCalculator.class);
    }
}
