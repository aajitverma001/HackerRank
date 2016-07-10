package cb;

import java.util.Arrays;

public class Question3 {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 5, 9, 10, 11, 12, 14, 17, 18, 19, 21 };
		findSquence(arr);
	}

	private static void findSquence(int[] arr) {
		Integer currentSeq[] = null;
		int j = 0;
		int sum = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] + 1 == arr[i + 1]) {
				if (currentSeq == null) {
					currentSeq = new Integer[arr.length];
				}
				currentSeq[j] = arr[i];
				sum += arr[i];
				j++;
				continue;
			}
			if (currentSeq != null) {
				currentSeq[j] = arr[i];// to add border element where continuity check failed
				sum += arr[i];
				j++;
				if (!ispresent(arr, sum)) {
					printArr(currentSeq);
				}
				currentSeq = null;
				sum = 0;
				j = 0;
			}
		}

	}

	static boolean ispresent(int[] arr, int sum) {// can be linear search 
		Arrays.sort(arr);
		int i = Arrays.binarySearch(arr, sum);
		if (i >= 0) {
			return true;
		}
		return false;
	}

	static void printArr(Integer arr[]) {
		System.out.print("[ ");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				continue;
			}
			System.out.print(arr[i] + " ");
		}
		System.out.print(" ]");
		System.out.println();
	}
}
