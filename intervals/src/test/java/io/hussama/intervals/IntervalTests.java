package io.hussama.intervals;

import io.hussama.intervals.exception.InvalidArgumentException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for the interval parsing.
 */
public class IntervalTests extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public IntervalTests(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(IntervalTests.class);
	}

	public void simpleInterval() {
		
	}
	
	public void testParseInterval1() {
		Interval interval = Interval.fromString("[2,-3[");
		assertNotNull(interval);
		assertEquals(2.0, interval.getStart());
		assertEquals(-3.0, interval.getEnd());
	}

	public void testParseInterval2() {
		Interval interval = Interval.fromString("[1.1,4[");
		assertNotNull(interval);
		assertEquals(1.1, interval.getStart());
		assertEquals(4.0, interval.getEnd());
	}

	public void testParseInterval3() {
		Interval interval = Interval.fromString("[1,7[");
		assertNotNull(interval);
		assertEquals(1.0, interval.getStart());
		assertEquals(7.0, interval.getEnd());
	}

	public void testParseIntervalFail1() {
		Interval interval = null;
		try {
			interval = Interval.fromString("[1 1,2");
		} catch (InvalidArgumentException e) {
			assertNull(interval);
		}
	}

	public void testParseIntervalFail2() {
		Interval interval = null;
		try {
			interval = Interval.fromString("[1 1,2[");
		} catch (InvalidArgumentException e) {
			assertNull(interval);
		}
	}

	public void testParseIntervalFail3() {
		Interval interval = null;
		try {
			interval = Interval.fromString("[1 2[");
		} catch (InvalidArgumentException e) {
			assertNull(interval);
		}
	}

}
