package dynamic_programming;

import java.util.Scanner;
/*
 * 
 *			 | 0               			 if (i=0 or j=0)	
 *	c[i,j] = | c[i-1, j-1] + 1 			 if(Xi = Yj)
 *			 | max(c[i, j-1], c[i-1, j]) if(Xi != Yj)	
 */
public class LongestCommonSubsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nm = sc.nextLine();
		String[] nInputs = sc.nextLine().split(" ");
		String[] mInputs = sc.nextLine().split(" ");
		int n = Integer.parseInt(nm.split(" ")[0]);
		int m = Integer.parseInt(nm.split(" ")[1]);
		int[][] c = new int[n + 1][m + 1];
		getAnswer(nInputs, mInputs, n, m, c);
		int index = c[n][m];
		int i = n, j = m;
		StringBuilder commonSeq = new StringBuilder();
		while (i > 0 && j > 0) {
			if (nInputs[i - 1].equals(mInputs[j - 1])) {
				commonSeq.insert(0, nInputs[i - 1]);
				if (index != 1) {
					commonSeq.insert(0, " ");
				}
				index--;
				i--;
				j--;
			} else if (c[i - 1][j] > c[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		System.out.println(commonSeq);
	}

	static void getAnswer(String[] nInputs, String[] mInputs, int n, int m,
			int[][] c) {
		for (int i = 0; i <= n; i++) {
			c[i][0] = 0;
		}
		for (int i = 0; i <= m; i++) {
			c[0][i] = 0;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (nInputs[i - 1].equals(mInputs[j - 1])) {
					c[i][j] = 1 + c[i - 1][j - 1];
				} else {
					c[i][j] = Math.max(c[i][j - 1], c[i - 1][j]);
				}
			}
		}
	}
}
