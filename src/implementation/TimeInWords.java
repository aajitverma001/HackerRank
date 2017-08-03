package implementation;

import java.util.Scanner;

public class TimeInWords {

	private static final String[] tensNames = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
			"eighty", "ninety" };

	private static final String[] numNames = { "", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int h = Integer.parseInt(sc.nextLine());
			int m = Integer.parseInt(sc.nextLine());
			if (m == 0) {
				printTime(null, null, numNames[h], "o' clock");
			} else if (m == 15) {
				printTime("quarter", "past", numNames[h], null);
			} else if (m == 45) {
				printTime("quarter", "to", numNames[h + 1], null);
			} else if (m == 30) {
				printTime("half", "past", numNames[h], null);
			} else if (m < 30) {
				String minInWords = inWords(m);
				printTime(minInWords, minutes(m) + " past", numNames[h], null);
			} else {
				String minInWords = inWords(60 - m);
				printTime(minInWords, minutes(m) + " to", numNames[h + 1], null);
			}
		} finally {
			sc.close();
		}
	}

	private static String minutes(int m) {
		if (m == 1) {
			return "minute";
		} else {
			return "minutes";
		}
	}

	private static String inWords(int m) {
		if (m < 20) {
			return numNames[m];
		}
		int tensDigit = m / 10;
		int unitDigit = m % 10;
		if (unitDigit == 0) {
			return tensNames[tensDigit];
		}
		return tensNames[tensDigit] + " " + numNames[unitDigit];
	}

	private static void printTime(String minutesInWords, String minutesSuffix, String hourInWords, String hourSuffix) {
		StringBuilder b = new StringBuilder();
		if (minutesInWords != null) {
			b.append(minutesInWords + " ");
		}
		if (minutesSuffix != null) {
			b.append(minutesSuffix + " ");
		}
		if (hourInWords != null) {
			b.append(hourInWords + " ");
		}
		if (hourSuffix != null) {
			b.append(hourSuffix);
		}
		System.out.println(b);
	}
}
