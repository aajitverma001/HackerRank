package project_euler;

import java.util.Scanner;

public class Problem1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		long[] testcases = new long[l];
		for (int i = 0; i < testcases.length; i++) {
			testcases[i] = sc.nextLong();
		}
		for (int i = 0; i < testcases.length; i++) {
			System.out.println(getSumOfMultiple(testcases[i]));
		}
	}

	private static long getSumOfMultiple(long l) {
		long n5 = (l - 1) / 5;
		long n3 = (l - 1) / 3;
		long n15 = (l - 1) / 15;
		long sum = 0;
		if (n5 == 1) {// for 5 multiples
			sum += 5;
		} else {
			sum += ((5 + (5 * n5)) * n5) / 2;
		}
		if (n3 == 1) {// for 3 multiples
			sum += 3;
		} else {
			sum += ((3 + (3 * n3)) * n3) / 2;
		}
		if (n15 == 1) {// for removing common multiple
			sum -= 15;
		} else {
			sum -= ((15 + (15 * n15)) * n15) / 2;
		}
		return sum;
	}
}
