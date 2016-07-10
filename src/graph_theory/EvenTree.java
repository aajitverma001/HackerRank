package graph_theory;

import java.util.*;

public class EvenTree {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int n = Integer.parseInt(line.split(" ")[0]);
		int m = Integer.parseInt(line.split(" ")[1]);
		List<Integer> list = null;
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < m; i++) {
			line = sc.nextLine();
			int b = Integer.parseInt(line.split(" ")[0]);
			int a = Integer.parseInt(line.split(" ")[1]);
			list = map.get(a);
			if (list == null) {
				list = new ArrayList<Integer>();
			}
			list.add(b);
			map.put(a, list);
		}
		int res = compute(map);
		System.out.println(res);
	}

	private static int compute(Map<Integer, List<Integer>> map) {
		int total = 0;
		int node = 1;
		List<Integer> list = map.get(node);
		List<Integer> list2 = null;
		while (!list.isEmpty()) {
			int child = list.remove(0);
			int count = getCount(child, map);
			if (count % 2 == 1) {
				total++;
			}
			list2 = map.get(child);
			if (list2 != null) {
				list.addAll(list2);
			}
		}
		return total;
	}

	private static int getCount(int node, Map<Integer, List<Integer>> map) {
		List<Integer> list = map.get(node);
		if (list != null) {
			int count1 = list.size();
			int count2 = 0;
			for (int v : list) {
				count2 += getCount(v, map);
			}
			return count1 + count2;
		}
		return 0;
	}
}
