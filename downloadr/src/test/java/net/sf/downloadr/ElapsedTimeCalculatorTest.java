package net.sf.downloadr;

import junit.framework.TestCase;

public class ElapsedTimeCalculatorTest extends TestCase {
	private ElapsedTimeCalculator calculator = new ElapsedTimeCalculator();

	public void testSimpleCase() {
		assertEquals("0 ms", calculator.calculateElapsedTime(100, 100));
		assertEquals("1 ms", calculator.calculateElapsedTime(1000, 1001));
		assertEquals("1 second(s)", calculator.calculateElapsedTime(1000, 2000));
		assertEquals("999 ms", calculator.calculateElapsedTime(1000, 1999));
		assertEquals("10 second(s)", calculator.calculateElapsedTime(10000, 20000));
		assertEquals("50 second(s)", calculator.calculateElapsedTime(0, 50000));
		assertEquals("1 minute(s) 0 second(s)", calculator.calculateElapsedTime(0, 60000));
		assertEquals("1 minute(s) 10 second(s)", calculator.calculateElapsedTime(0, 70000));
		assertEquals("3 hour(s) 0 minute(s) 0 second(s)", calculator.calculateElapsedTime(0, 10800000));
		assertEquals("3 hour(s) 0 minute(s) 1 second(s)", calculator.calculateElapsedTime(0, 10801000));
	}
}
