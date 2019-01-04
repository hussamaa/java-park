package io.hussama.intervals;

import io.hussama.intervals.exception.InvalidArgumentException;

/**
 * Class that represents an Interval.
 * 
 * @author Hussama Ismail
 */
public class Interval {

	private double start;
	private double end;

	private Interval() {
	}

	public double getStart() {
		return start;
	}

	public double getEnd() {
		return end;
	}

	/**
	 * Parse a string into an interval. It should respect the following syntax: '[
	 * 10, 31 ['. Otherwise, an InvalidArgumentException will be thrown.
	 * 
	 * @param str
	 * @return
	 */
	public static Interval fromString(String str) {

		Interval interval = null;

		/* removes empty spaces at the beginning and end of the string */
		String trimmedString = str.trim();
		int length = trimmedString.length();

		/* first checks if the first and last characters are the same. */
		if ((trimmedString.charAt(0) == '[') && ('[' == trimmedString.charAt(length - 1))) {
			String substring = trimmedString.substring(1, length - 1);
			String[] values = substring.split(",");
			try {
				interval = new Interval();
				interval.start = Double.valueOf(values[0]);
				interval.end = Double.valueOf(values[1]);
			} catch (RuntimeException e) {
				throw new InvalidArgumentException();
			}
		}
		return interval;
	}
}
