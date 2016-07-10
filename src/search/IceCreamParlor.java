package search;

import java.util.*;

public class IceCreamParlor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		int[][] mn = new int[t][2];
		List<Integer[]> inp = new ArrayList<Integer[]>();
		for (int i = 0; i < t; i++) {
			mn[i][0] = Integer.parseInt(sc.nextLine());
			mn[i][1] = Integer.parseInt(sc.nextLine());
			String[] str = sc.nextLine().split(" ");
			Integer[] a = new Integer[mn[i][1]+1];
			for (int j = 1; j <= str.length; j++) {
				a[j] = Integer.parseInt(str[j-1]);
			}
			inp.add(a);
		}
		for (int i = 0; i < t; i++) {
			findSol(mn[i][0], mn[i][1], inp.get(i));
		}
	}

	private static void findSol(int k, int l, Integer[] integers) {
		for (int i = 1; i <= l; i++) {
			int j = l;
			while (j > 0) {
				if (integers[i] + integers[j] == k && j!=i) {
					System.out.println(i + " " + j);
					return;
				}
				j--;
			}

		}
	}
}
