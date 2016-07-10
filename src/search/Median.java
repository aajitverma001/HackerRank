package search;

import java.text.DecimalFormat;
import java.util.*;

public class Median {
	static void median(String a[], int x[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int n = a.length;
		for (int i = 0; i < n; i++) {
			String operation = a[i];
			Integer num = x[i];
			if (operation.equals("r")) {
				if (list.isEmpty()) {
					System.out.println("Wrong!");
				} else {
					int index = Collections.binarySearch(list, num);
					if (index >= 0) {
						list.remove(index);
						if (list.isEmpty()) {
							System.out.println("Wrong!");
						} else {
							findMedian(list);
						}
					} else {
						System.out.println("Wrong!");
					}
				}
			} else {
				int index = findIndex(list, num);
				list.add(index, num);
				findMedian(list);
			}

		}

	}

	private static int findIndex(ArrayList<Integer> list, Integer num) {
		if (list.isEmpty()) {
			return 0;
		}
		int leftIndex = 0;
		int rightIndex = list.size() - 1;
		int middleIndex = 0;
		while (leftIndex <= rightIndex) {
			middleIndex = (leftIndex + rightIndex) / 2;
			if (num == list.get(middleIndex))
				return middleIndex;
			else if (num < list.get(middleIndex))
				rightIndex = middleIndex - 1;
			else
				leftIndex = middleIndex + 1;
		}
		if (middleIndex <= 0)
			middleIndex = 0;
		else if (middleIndex >= list.size())
			middleIndex = list.size();
		if (list.get(middleIndex).compareTo(num) < 0)
			++middleIndex;
		return middleIndex;
	}

	private static void findMedian(ArrayList<Integer> list) {
		int l = list.size();
		int i = (l / 2);
		i++;
		if (l % 2 != 0) {
			System.out.println(list.get(i - 1));
		} else {
			long num = list.get(i - 1);
			long num2 = list.get(i - 2);
			Double m = (double) ((num + num2) / 2.0);
			if (m == (double) m.intValue()) {
				System.out.println(m.intValue());
			} else {
				DecimalFormat df = new DecimalFormat("#.#");
				System.out.println(df.format(m));
			}
		}

	}

	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);

		int N;
		N = in.nextInt();

		String s[] = new String[N];
		int x[] = new int[N];

		for (int i = 0; i < N; i++) {
			s[i] = in.next();
			x[i] = in.nextInt();
		}
		long time = System.currentTimeMillis();
		median(s, x);
		long nettime = System.currentTimeMillis() - time;
		System.out.println("time  :"+ nettime);
	}
}
