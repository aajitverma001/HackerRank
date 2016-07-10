package dynamic_programming;

import java.util.*;

public class Equal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		int[] ans = new int[t];
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(sc.nextLine());
			String[] inp = sc.nextLine().split(" ");
			int[] arr = new int[n];
			for (int j = 0; j < inp.length; j++) {
				arr[j] = Integer.parseInt(inp[j]);
			}
			ans[i] = findOperation(arr, n);
		}
		for (int i = 0; i < t; i++) {
			System.out.println(ans[i]);
		}
	}

	private static int findOperation(int[] arr, int N) {
		if (N < 2) {
			return 0;
		}
		int minVal = arr[0];
		for (int i = 1; i < N; ++i) {
			if (arr[i] < minVal) {
				minVal = arr[i];
			}
		}
		int minCount = Integer.MAX_VALUE;
		for (int i = 0; i <= 5; ++i) {
			int count = 0;
			for (int j = 0; j < N; ++j) {
				int V = (arr[j] - (minVal - i));
				count += V / 5 + (V %= 5) / 2 + (V & 1);
			}
			if (count < minCount) {
				minCount = count;
			}
		}
		return minCount;
	}

}
