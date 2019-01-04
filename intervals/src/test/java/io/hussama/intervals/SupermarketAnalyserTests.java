package io.hussama.intervals;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for the Supermarket Analyser.
 */
public class SupermarketAnalyserTests extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public SupermarketAnalyserTests(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(SupermarketAnalyserTests.class);
	}

	/**
	 * Supermarket Analyser.
	 */
	public void testSimpleInterval() {
		Interval[] intervals = { Interval.fromString("[1,2[") };
		Interval[] analyse = SupermarketAnalyser.analyse(intervals);
		assertTrue(analyse.length == 1);
		assertTrue(analyse[0].getStart() == 1.0);
		assertTrue(analyse[0].getEnd() == 2.0);
	}

	public void testOverlapBetween2And3() {
		Interval[] intervals = { Interval.fromString("[1,3["), Interval.fromString("[2,4[") };
		Interval[] analyse = SupermarketAnalyser.analyse(intervals);
		assertTrue(analyse.length == 2);
		assertTrue(analyse[0].getStart() == 1.0);
		assertTrue(analyse[0].getEnd() == 2.0);
	}
}
