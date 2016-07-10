import java.io.*;
import java.util.*;

public class AngryChildren {
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int numPackets = Integer.parseInt(in.readLine());
		int numKids = Integer.parseInt(in.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < numPackets; i++) {
			arr.add(Integer.parseInt(in.readLine()));
		}
		unfairness(numPackets, numKids, arr);

	}
	

	public static void subsets(int n, int k, int i, ArrayList<Integer> arr,
			Set<Integer> current, ArrayList<Set<Integer>> subsets) {
		if (current.size() == k) {
			subsets.add(new HashSet<Integer>(current));
			return;
		}
		if (i == n) {
			return;
		}
		Integer x = arr.get(i);
		current.add(x);
		subsets(n, k, i + 1, arr, current, subsets);
		current.remove(x);
		subsets(n, k, i + 1, arr, current, subsets);

	}

	public static void unfairness(int n, int k, ArrayList<Integer> arr) {
		ArrayList<Set<Integer>> subsets = new ArrayList<Set<Integer>>();
		subsets(n, k, 0, arr, new HashSet<Integer>(), subsets);
		int min = Collections.max(subsets.get(0))
				- Collections.min(subsets.get(0));
		for (Set<Integer> set : subsets) {
			int curr = Collections.max(set) - Collections.min(set);
			if (curr < min) {
				min = curr;
			}
		}
		System.out.println(min);
	}
}
