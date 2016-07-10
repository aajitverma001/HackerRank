package project_euler;

import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		long[] testcases = new long[l];
		for (int i = 0; i < testcases.length; i++) {
			testcases[i] = sc.nextLong();
		}
		for (int i = 0; i < testcases.length; i++) {
			System.out.println(getEvenFibTermSum(testcases[i]));
		}
	}

	private static long getEvenFibTermSum(long l) {
		long a = 1, b = 2, sum = 0;
		if (l < 2) {
			return 0;
		}
		long next = 2;
		while (next < l) {
			if (next % 2 == 0) {
				sum += next;
			}
			next = a + b;
			a = b;
			b = next;
		}
		return sum;
	}
}
