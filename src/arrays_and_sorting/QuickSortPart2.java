package arrays_and_sorting;

import java.util.Scanner;

public class QuickSortPart2 {
	static void quickSort(int[] ar) {
		sort(ar, 0, ar.length - 1);
	}

	static void sort(int[] ar, int p, int r) {
		if (p < r) {
			int q = partition(ar, p, r);
			sort(ar, p, q - 1);
			sort(ar, q + 1, r);
			printArray(ar);
		}
	}

	static int partition(int[] ar, int p, int r) {
		int x = ar[r];
		int i = p - 1;
		int temp;
		for (int j = p; j < r; j++) {
			if (ar[j] <= x) {
				i++;
				temp = ar[i];
				ar[i] = ar[j];
				ar[j] = temp;
			}
		}
		temp = ar[i + 1];
		ar[i + 1] = ar[r];
		ar[r] = temp;
		return i + 1;
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		quickSort(ar);
	}
}
