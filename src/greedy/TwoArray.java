package greedy;

import java.util.*;

/*
 Problem Statement

 You are given two integer arrays, A and B, each containing N integers. The size of the array is less than or equal to 1000. You are free to permute the order of the elements in the arrays.

 Now here's the real question: Is there an permutation A', B' possible of A and B, such that, A'i+B'i ³ K for all i, where A'i denotes the ith element in the array A' and B'i denotes ith element in the array B'.


 Input Format
 The first line contains an integer, T, the number of test-cases. T test cases follow. Each test case has the following format:

 The first line contains two integers, N and K. The second line contains N space separated integers, denoting array A. The third line describes array B in a same format.

 Output Format
 For each test case, if such an arrangement exists, output "YES", otherwise "NO" (without quotes).


 Constraints
 1 <= T <= 10
 1 <= N <= 1000
 1 <= K <= 109
 0 <= Ai, Bi ² 109


 Sample Input

 2
 3 10
 2 1 3
 7 8 9
 4 5
 1 2 2 1
 3 3 3 4

 Sample Output

 YES
 NO
 Explanation

 The first input has 3 elements in Array A and Array B, we see that the one of the arrangements, 3 2 1 and 7 8 9 has each pair of elements (3+7, 2 + 8 and 9 + 1) summing upto 10 and hence the answer is "YES".

 The second input has array B with three 3s. So, we need at least three numbers in A that are greater than 1. As this is not the case, the answer is "NO".
 */
public class TwoArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int _t = Integer.parseInt(sc.nextLine());
		int[] N = new int[_t];
		int[] K = new int[_t];
		ArrayList<Integer[]> aArrayList = new ArrayList<Integer[]>();
		ArrayList<Integer[]> bArrayList = new ArrayList<Integer[]>();
		for (int i = 0; i < _t; i++) {
			String inp = sc.nextLine();
			N[i] = Integer.parseInt(inp.split(" ")[0]);
			K[i] = Integer.parseInt(inp.split(" ")[1]);
			aArrayList.add(i, new Integer[N[i]]);
			bArrayList.add(i, new Integer[N[i]]);
			String[] inpArr1 = sc.nextLine().split(" ");
			String[] inpArr2 = sc.nextLine().split(" ");
			for (int j = 0; j < N[i]; j++) {
				aArrayList.get(i)[j] = Integer.parseInt(inpArr1[j]);
				bArrayList.get(i)[j] = Integer.parseInt(inpArr2[j]);
			}
		}
		for (int i = 0; i < _t; i++) {
			solve(N[i], K[i], aArrayList.get(i), bArrayList.get(i));
		}
	}

	private static void solve(int N, int K, Integer[] a, Integer[] b) {
		Arrays.sort(b);
		Arrays.sort(a);
		int c1 = 0, c2 = 0, i = 0, k = 0;
		for (; i < N; i++) {
			if (a[i] + b[i] >= K)
				c1++;
		}
		for (i = N - 1; i >= 0; i--) {
			if (a[k] + b[i] >= K)
				c2++;
			k++;
		}
		if (c1 == N || c2 == N) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
