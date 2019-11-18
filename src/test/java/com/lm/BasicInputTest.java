package com.lm;

import junit.framework.TestCase;

public class BasicInputTest extends TestCase {
	public void InputOneTest() {
		String input1 = "1 book at 12.49\n" + 
				"1 music CD at 14.99\n" + 
				"1 chocolate bar at 0.85";
		ReceiptCalculator receiptCalculator = new ReceiptCalculator(input1);
		String output = receiptCalculator.execute();
		assertEquals("1 book : 12.49\n" +
				"1 music CD: 16.49\n" +
				"1 chocolate bar: 0.85\n" +
				"Sales Taxes: 1.50\n" +
				"Total: 29.83", output);
	}
}
