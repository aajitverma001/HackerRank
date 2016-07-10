package dynamic_programming;

import java.util.*;
//jcaabdovmuiwsjkskeyifhfjxebwqbuqkndxmrxpqdbnpecgdh
//63
//dbcbcbededadecbcdecbaeadcecada
//99

/*
 * 			 |	0						if(j-i=0)
 * 			 |  1						if(j-1 = i)
 * f(i ,j) = |  max(f(i-1,j),f(i,j-1))	if(j-i > 1 && Si != Sj-1)
 * 			 |  2 + f(i+1, j+1) 		if(j-i > 1 && Si == Sj-1)	 			
 */
public class PlayWithWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inpStr = sc.nextLine();
		System.out.println(getAnswer(inpStr));
	}

	static int getAnswer(String str) {
		int l = str.length();
		int[][] longestPalindrome = new int[l][l];
		getLongestPalindromeSubsequeceLength(str, l, longestPalindrome);
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				System.out.print(longestPalindrome[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		int res = 0;
		for (int i = 1; i < l; i++) {
			int v1 = longestPalindrome[0][i - 1];
			int v2 = longestPalindrome[i][l - 1];
			res = Math.max(res, v1 * v2);
		}
		return res;
	}

	static void getLongestPalindromeSubsequeceLength(String str, int n,
			int[][] longestPalindrome) {
		for (int i = 0; i < n; i++) {
			longestPalindrome[i][i] = 1;
		}
		for (int gap = 1; gap < n; gap++) {
			for (int i = 0; i < n - gap; i++) {
				int j = i + gap;
				if (str.charAt(i) == str.charAt(j) && gap == 1)
					longestPalindrome[i][j] = 2;
				else if (str.charAt(i) == str.charAt(j))
					longestPalindrome[i][j] = longestPalindrome[i + 1][j - 1] + 2;
				else
					longestPalindrome[i][j] = Math.max(
							longestPalindrome[i][j - 1],
							longestPalindrome[i + 1][j]);
			}
		}
	}

	// static int getAnswer(String inpStr) {
	// Set<Integer> len = new TreeSet<Integer>();
	// for (int i = 0; i <= inpStr.length() - 2; i++) {
	// String comb1 = inpStr.substring(0, inpStr.length() - (1 + i));
	// String comb2 = inpStr.substring(inpStr.length() - (1 + i),
	// inpStr.length());
	// // System.out.println(comb1);
	// // System.out.println(comb2);
	// if (len.size() > 0
	// && (comb1.length() * comb2.length()) < Collections.max(len)) {
	// continue;
	// }
	// int prod = getLongestPalindromeSubsequeceLength(comb1, 0, )
	// * getLongestPalindromeSubsequeceLength(comb2);
	// len.add(prod);
	// if(prod == 664858){
	// System.err.println(i);
	// System.out.println((System.currentTimeMillis()-mill)/1000.0);
	// }
	// // System.out.println(prod);
	//
	// }
	//
	// System.out.print(len);
	// return Collections.max(len);
	// }

	static int getLongestPalindromeSubsequeceLength(String str, int i, int j) {
		if (i == j) {
			return 1;
		}
		if (str.charAt(i) == str.charAt(j) && j == i + 1) {
			return 2;
		}
		if (str.charAt(i) == str.charAt(j)) {
			return getLongestPalindromeSubsequeceLength(str, i + 1, j - 1) + 2;
		}
		return Math.max(getLongestPalindromeSubsequeceLength(str, i + 1, j),
				getLongestPalindromeSubsequeceLength(str, i, j - 1));
	}

	/**
	 * To find longest palindrome sub-sequence It has time complexity O(N^2)
	 * 
	 * @param source
	 * @return String
	 */
	public static String getLongestPalindromicSubSequence(String source) {
		int n = source.length();
		int[][] LP = new int[n][n];

		// All sub strings with single character will be a plindrome of size 1
		for (int i = 0; i < n; i++) {
			LP[i][i] = 1;
		}
		// Here gap represents gap between i and j.
		for (int gap = 1; gap < n; gap++) {
			for (int i = 0; i < n - gap; i++) {
				int j = i + gap;
				if (source.charAt(i) == source.charAt(j) && gap == 1)
					LP[i][j] = 2;
				else if (source.charAt(i) == source.charAt(j))
					LP[i][j] = LP[i + 1][j - 1] + 2;
				else
					LP[i][j] = Math.max(LP[i][j - 1], LP[i + 1][j]);
			}
		}
		// Rebuilding string from LP matrix
		StringBuffer strBuff = new StringBuffer();
		int x = 0;
		int y = n - 1;
		while (x < y) {
			if (source.charAt(x) == source.charAt(y)) {
				strBuff.append(source.charAt(x));
				x++;
				y--;
			} else if (LP[x][y - 1] > LP[x + 1][y]) {
				y--;
			} else {
				x++;
			}
		}
		StringBuffer strBuffCopy = new StringBuffer(strBuff);
		String str = strBuffCopy.reverse().toString();
		if (x == y) {
			strBuff.append(source.charAt(x)).append(str);
		} else {
			strBuff.append(str);
		}
		return strBuff.toString();
	}

}
