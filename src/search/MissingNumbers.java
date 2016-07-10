package search;

import java.util.*;

public class MissingNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] na = sc.nextLine().split(" ");
		int m = Integer.parseInt(sc.nextLine());
		String[] ma = sc.nextLine().split(" ");
		Map<Integer, Integer> c1 = charCounter(na);
		Map<Integer, Integer> c2 = charCounter(ma);
		Set<Integer> set = new TreeSet<Integer>();
		for (Map.Entry<Integer, Integer> en : c2.entrySet()) {
			if (c1.containsKey(en.getKey())
					&& ((Integer) c1.get(en.getKey())).intValue() != ((Integer) en
							.getValue()).intValue()) {
				set.add(en.getKey());
			}
			if (!c1.containsKey(en.getKey())) {
				set.add(en.getKey());
			}
		}
		for (Integer s : set) {
			System.out.print(s + " ");
		}
	}

	static Map<Integer, Integer> charCounter(String[] arr) {
		Map<Integer, Integer> charCount = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			Integer c = Integer.parseInt(arr[i]);
			if (charCount.containsKey(c)) {
				charCount.put(c, charCount.get(c) + 1);
			} else {
				charCount.put(c, 1);
			}
		}
		return charCount;
	}

}
