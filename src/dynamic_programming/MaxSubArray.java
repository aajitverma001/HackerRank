package dynamic_programming;

import java.util.*;

public class MaxSubArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		int[] l = new int[t];
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		for (int i = 0; i < l.length; i++) {
			l[i] = Integer.parseInt(sc.nextLine());
			Integer[] arr = new Integer[l[i]];
			String[] inp = sc.nextLine().split(" ");
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(inp[j]);
			}
			list.add(i, arr);
		}
		for (int i = 0; i < t; i++) {
			subArraySum(l[i], list.get(i));
		}
	}

	/**
	 * Contiguous Sub Array problem. bestSum denotes the Contiguous Sub Array
	 * sum.
	 * 
	 * @param i
	 * @param integers
	 * @return
	 */
	private static void subArraySum(int i, Integer[] integers) {
		int currentSum = 0;
		int currentIndex = -1;
		int bestSum = 0;
		int bestStartIndex = -1;
		int bestEndIndex = -1;
		int nonCountigousSum = 0;
		boolean isNonNegativeNumberPresent = false;
		int max = integers[0];
		for (int j = 0; j < integers.length; j++) {
			int val = currentSum + integers[j];
			if (val > 0) {
				if (currentSum == 0) {
					currentIndex = j;
				}
				currentSum = val;
			} else {
				currentSum = 0;
			}
			if (currentSum > bestSum) {
				bestSum = currentSum;
				bestStartIndex = currentIndex;
				bestEndIndex = j;
			}

			//non Contiguous logic
			if (integers[j] > 0) {
				isNonNegativeNumberPresent = true;
				nonCountigousSum += integers[j];
			}
			if (integers[j] > max) {
				max = integers[j];
			}
		}
		if (!isNonNegativeNumberPresent) {
			nonCountigousSum = max;
			bestSum = max;
		}
		System.out.println(bestSum + " " + nonCountigousSum);
	}
}
