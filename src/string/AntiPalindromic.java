package string;

import java.math.BigInteger;
import java.util.Scanner;

/*
 Problem Statement

 You are given two integers, N and M. Count the number of strings of length N under the alphabet set of size M that doesn't contain any palindromic string of the length greater than 1 as a consecutive substring.

 Input Format

 Several test cases will be given to you in a single file. The first line of the input will contain a single integer, T, the number of test cases.

 Then there will be T lines, each containing two space-separated integers, N and M, denoting a single test case. The meanings of N and M are described in the Problem Statement above.

 Output Format

 For each test case, output a single integer - the answer to the corresponding test case. This number can be huge, so output it modulo 109+7.

 Constraints

 1²T²105
 1²N,M²109
 Sample Input

 2
 2 2
 2 3
 Sample Output

 2
 6
 Explanation

 For the 1st testcase, we have an alphabet of size M = 2. For the sake of simplicity, let's consider the alphabet as [A, B]. We can construct four strings of size N = 2 using these letters.

 AA
 AB
 BA
 BB
 Out of these, we have two strings, AB and BA, that satisfy the condition of not having a palindromic string of length greater than 1. Hence, the answer 2.

 For the 2nd test case, we have an alphabet of size M = 3. For the sake of simplicity, let's consider the alphabet as [A, B, C]. We can construct nine strings of size N = 2 using these letters.

 AA
 AB
 AC
 BA
 BB
 BC
 CA
 CB
 CC
 Save AA, BB, and CC, all the strings satisfy the given condition; hence, the answer 6.

 solution:
 Any palindrome, it has a sub-palindrome with length 2 or 3 at the center
 There are (M-2) ways to choose symbol, since it should not be the same as previous or previous-previous symbols
 total = M*(M-1)*(M-2)*(M-2)*(M-2)...
 */
/**
 * Incorrect
 */
public class AntiPalindromic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		int[][] inp = new int[t][2];
		for (int i = 0; i < inp.length; i++) {
			String str = sc.nextLine();
			inp[i][0] = Integer.parseInt(str.split(" ")[0]);
			inp[i][1] = Integer.parseInt(str.split(" ")[1]);
		}
		for (int i = 0; i < inp.length; i++) {
			genNonPalindrome(inp[i][0], inp[i][1]);
		}
	}

	static void genNonPalindrome(int N, int M) {
		long mod = 1000000007;
		long s = M;
		if (N > 1) {
			s *= (M - 1);
		}
		if (N > 2) {
			BigInteger m = BigInteger.valueOf(M - 2);
			BigInteger n = BigInteger.valueOf(N - 2);
			BigInteger MOD = BigInteger.valueOf(mod);
			s *= m.modPow(n, MOD).longValue();
			s %= mod;
		}
		System.out.println(s % mod);
	}

	static long _exp(int a, int b, long MOD) {
		long ret = 1;
		b %= MOD;
		while (b > 0) {
			if ((b & 1) == 0) {
				b /= 2;
				a *= a;
				a %= MOD;
			} else {
				ret *= a;
				ret %= MOD;
				b -= 1;
			}
		}
		return ret;
	}
}
