package combinatorics;

import java.util.*;

public class AllCombination {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		Map<Integer, String> inp = new HashMap<Integer, String>();
		for (int i = 0; i < t; i++) {
			inp.put(Integer.parseInt(sc.nextLine()), sc.nextLine());
		}
		for (Map.Entry<Integer, String> en : inp.entrySet()) {
			printCombination(en.getKey(), en.getValue());
		}
	}

	private static void printCombination(Integer len, String str) {
		Set<String> res = new TreeSet<String>();
		char[] s = str.toCharArray();
		Arrays.sort(s);
		combination(0, res, len, s, new StringBuilder());
		for (String re : res) {
			System.out.println(re);
		}
	}

	private static void combination(int index, Set<String> res, int len,
			char[] str, StringBuilder r) {
		for (int i = index; i < len; i++) {
			r.append(str[i]);
			res.add(r.toString());
			if (i < len) {
				combination(i + 1, res, len, str, r);
			}
			r.setLength(r.length() - 1);
		}
	}
}
