package dynamic_programming;

import java.util.*;

/*	
 *	D is Array
 *	l(i) =  Max (L(j) | j<i, D[j] < D[i]) + D[i]
 *			|
 *	ls(i) = | 1 + max(ls(j))	 where 1<j<i and d[i]>d[j];
 *			| 1   				 if no such j exist
 * 
 */

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] d = new int[n];
		for (int i = 0; i < d.length; i++) {
			d[i] = Integer.parseInt(sc.nextLine());
		}
		lise(d, n);
	}
	
	private static void lise(int[] X, int n) {
		int[] p = new int[n];
		int[] m = new int[n + 1];
		int L = 0;
		for (int i = 0; i < n; i++) {
			int lo = 1;
			int hi = L;
			while (lo <= hi) {
				int mid = ((Double) Math.ceil((lo + hi) / 2)).intValue();
				if (X[m[mid]] < X[i]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
			int newL = lo;
			p[i] = m[newL - 1];
			m[newL] = i;
			if (newL > L) {
				L = newL;
			}
		}
		System.out.println(L);

	}

	private static void lis(int[] d, int n) {
		int[] lis = new int[n];
		Arrays.fill(lis, 1);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (d[i] > d[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}

			}
		}
		int max = lis[0];
		for (int i : lis) {
			if (i > max) {
				max = i;
			}
		}
		System.out.println(max);
	}

	
}
