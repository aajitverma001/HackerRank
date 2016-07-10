package greedy;

import java.util.*;
// incorrect
public class LargestPermutation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inp = sc.nextLine();
		int N = Integer.parseInt(inp.split(" ")[0]);
		int K = Integer.parseInt(inp.split(" ")[1]);
		int[] sorted = new int[N];
		int[] arr = new int[N];
		inp = sc.nextLine();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(inp.split(" ")[i]);
			sorted[i] = arr[i];
		}
		Arrays.sort(sorted);
		for (int i = 0; i < K; i++) {
			int index = findIndex(arr, sorted[N-1-i], i);
			if(index == -1){
				continue;
			}
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
		printArr(arr);
	}

	private static int findIndex(int[] arr, int k, int i) {
		for (int j = i; j < arr.length; j++) {
			if(arr[j] == k){
				return j;
			}
		}
		return -1;
	}

	static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
