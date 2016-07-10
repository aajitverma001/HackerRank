package string;

import java.util.*;
//incorrect
public class SubstringDiff {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		String[][] inp = new String[T][2];
		int[] ks = new int[T];
		for (int i = 0; i < T; i++) {
			String s = sc.nextLine();
			ks[i] = Integer.parseInt(s.split(" ")[0]);
			inp[i][0] = s.split(" ")[1];
			inp[i][1] = s.split(" ")[2];
		}

		for (int i = 0; i < T; i++) {
			System.out.println(Math.max(subDiff(inp[i][0], inp[i][1], ks[i]),
					subDiff(inp[i][1], inp[i][0], ks[i])));
		}
	}

	private static int subDiff(String string, String string2, int k) {
		int ans = 0;
		List<Integer> bits;
		char[] s1 = string.toCharArray();
		char[] s2 = string2.toCharArray();
		for (int i = 0; i < s1.length; i++) {
			bits = new ArrayList<Integer>();
			for (int j = 0; j < s2.length && j + i < s1.length; j++) {
				if (s1[i + j] != s2[j]) {
					bits.add(1);
				} else {
					bits.add(0);
				}
			}
			System.out.println(bits);
			int start = 0;
			int cnt = 0;
			for (int j = 0; j < bits.size(); j++) {
				cnt += bits.get(j);
				if (k > 0) {
					while (cnt > k) {
						start++;
						cnt -= bits.get(start);
						ans = Math.max(ans, j - start + 1);
					}
				}
			}
			if (k == 0) {
				ans = s1.length - cnt - 1;
				break;
			}
		}
		return ans;
	}
}
