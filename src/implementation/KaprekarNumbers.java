package implementation;

import java.util.*;

public class KaprekarNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int start = Integer.parseInt(sc.nextLine());
			int end = Integer.parseInt(sc.nextLine());
			List<Integer> kNum = new ArrayList<>();
			for (int i = start; i <= end; i++) {
				if (isKaprekarNumber(i)) {
					kNum.add(i);
				}
			}
			if (kNum.isEmpty()) {
				System.out.println("INVALID RANGE");
			} else {
				kNum.forEach((k) -> {
					System.out.print(k + " ");
				});
			}
		} finally {
			sc.close();
		}

	}

	private static boolean isKaprekarNumber(int n) {
		if (n == 1) {
			return true;
		}
		Long square = ((long) n) * ((long) n);
		String numStr = "" + n;
		String sqString = "" + square;
		int nLen = numStr.length();
		int sqLen = sqString.length();
		int r = Integer
				.parseInt(sqString.substring(sqLen - nLen).length() == 0 ? "0" : sqString.substring(sqLen - nLen));
		int l = Integer.parseInt(
				sqString.substring(0, sqLen - nLen).length() == 0 ? "0" : sqString.substring(0, sqLen - nLen));
		return r + l == n;
	}
}
