package string;

import java.util.Scanner;

public class LongestCommonSubsequenceLength {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inp1 = sc.nextLine();
		String inp2 = sc.nextLine();
		int len = getLongestSubsequenceLength(inp1, inp2, inp1.length(),
				inp2.length());
		System.out.println(len);
	}

	private static int getLongestSubsequenceLength(String inp1, String inp2,
			int m, int n) {
		int[][] l = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			l[i][0] = 0;
		}
		for (int i = 0; i <= n; i++) {
			l[0][i] = 0;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (inp1.charAt(i - 1) == inp2.charAt(j - 1)) {
					l[i][j] = 1 + l[i - 1][j - 1];
				} else {
					l[i][j] = Math.max(l[i - 1][j], l[i][j - 1]);
				}
			}
		}
		return l[n][m];
	}
}
