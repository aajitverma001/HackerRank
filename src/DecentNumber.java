import java.util.Scanner;

public class DecentNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		long[] n = new long[t];
		for (int i = 0; i < n.length; i++) {
			n[i] = Long.parseLong(in.nextLine());
		}
		getResult(n);
	}

	
	
	
	/**
	 * // 5X + 3Y = N => Y = (N-5X)/3 -> 1 => taking congruent modulo 3 => N-5X
	 * == 0 => N == 5X == 2X => multiplying both side by 2 => 2N == 4X == X => X
	 * = 2N % 3 => placing value of x in -> 1 => Y = (N - 5(2N % 3))/3
	 * 
	 * @param n
	 */
	private static void getResult(long[] n) {
		for (long l : n) {
			long c = 5 * (2 * l % 3);
			if (c > l) {
				System.out.println(-1);
			} else {
				StringBuffer sb = new StringBuffer();
				long fives = (l-c);
				long threes = c;
				while ((fives -= 3) >= 0) {
					sb.append("555");
				}
				while ((threes -= 5) >= 0) {
					sb.append("33333");
				}
				System.out.println(sb);
			}
		}
	}

	private static String method2(final int target) {
		int threes = 0;
		int fives = 0;
		int digits = target;
		while (digits > 0) {
			if (digits % 3 == 0) {
				fives = digits;
				break;
			}
			digits -= 5;
		}
		threes = target - digits;
		if (digits < 0 || threes % 5 != 0) {
			return "-1";
		}
		StringBuilder sb = new StringBuilder(target);
		while ((fives -= 3) >= 0) {
			sb.append("555");
		}
		while ((threes -= 5) >= 0) {
			sb.append("33333");
		}
		return sb.toString();
	}
}
