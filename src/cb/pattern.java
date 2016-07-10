package cb;

import java.util.Scanner;

public class pattern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n % 2 == 0) {
			System.out.println("Number is even");
		} else {
			printPattern(n);
		}
	}

	private static void printPattern(int n) {
		int m = n / 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i <= m) {
					if (j == i || j == n - 1 - i) {
						System.out.print(" * ");
					} else {
						System.out.print(" - ");
					}
				} else {
					if (j >= n - 1 - i && j <= i) {
						System.out.print(" * ");
					} else {
						System.out.print(" - ");
					}
				}
			}
			System.out.println();
		}

	}
}
