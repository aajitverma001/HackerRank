package arrays_and_sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class QuickSorPart1 {
	static void partition(int[] ar) {
		int p = ar[0];
		ArrayList<Integer> r = new ArrayList<Integer>();
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i = 1; i < ar.length; i++) {
			if(ar[i]>=p){
				l.add(ar[i]);
			}else {
				r.add(ar[i]);
			}
		}
		int i = 0;
		for (Integer integer : r) {
			ar[i] = integer;
			i++;
		}
		ar[i] = p;
		i++;
		for (Integer integer : l) {
			ar[i] = integer;
			i++;
		}
		printArray(ar);
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
		partition(ar);
	}
}
