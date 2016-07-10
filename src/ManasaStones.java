import java.util.*;

public class ManasaStones {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		int[][] inp = new int[t][3];
		for (int i = 0; i < t; i++) {
			inp[i][0] = Integer.parseInt(sc.nextLine());
			inp[i][1] = Integer.parseInt(sc.nextLine());
			inp[i][2] = Integer.parseInt(sc.nextLine());
		}
		for (int i = 0; i < t; i++) {
			manasaStones(inp[i][0], inp[i][1], inp[i][2]);
		}
	}

	private static void manasaStones(int i, int j, int k) {
		int first, last, diff, num;
		if (j < k) {
			first = (i - 1) * j;
			last = (i - 1) * k;
			diff = k - j;
		} else {
			first = (i - 1) * k;
			last = (i - 1) * j;
			diff = j - k;
		}
		Set<Integer> result = new TreeSet<Integer>();
		result.add(first);
		num = first;
		while (num < last) {
			num += diff;
			result.add(num);
		}
		result.add(last);

		for (Integer integer : result) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}
}
