package project_euler;

import java.util.Scanner;

public class Problem3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		long[] testcases = new long[l];
		for (int i = 0; i < testcases.length; i++) {
			testcases[i] = sc.nextLong();
		}
		for (int i = 0; i < testcases.length; i++) {
			System.out.println(largestPrimeFactor(testcases[i]));
		}
	}

	private static long largestPrimeFactor(long l) {
		long i;
		for (i = 2; i <= l; i++) {
			if (l % i == 0) {
				l /= i;
				i--;
			}
		}
		return i;
	}
}
