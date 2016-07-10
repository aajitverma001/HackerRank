import java.util.*;

public class SherlockAndArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		int[] n = new int[t];
		List<Integer[]> l = new ArrayList<Integer[]>();
		for (int i = 0; i < t; i++) {
			n[i] = Integer.parseInt(sc.nextLine());
			Integer[] inp = new Integer[n[i]];
			String[] arr = (sc.nextLine()).split(" ");
			for (int j = 0; j < inp.length; j++) {
				inp[j] = Integer.parseInt(arr[j]);
			}
			l.add(inp);
		}
		for (int i = 0; i < t; i++) {
			getResult(n[i], l.get(i));
		}
	}

	private static void getResult(int i, Integer[] integers) {
		int rightSum = 0, leftSum = 0;
		boolean has = false;
		for (int j = 0; j < integers.length; j++) {
			rightSum += integers[j];
		}
		for (int j = 0; j < integers.length; j++) {
			rightSum -= integers[j];
			System.out.println(" " + j + " " + leftSum + " " + rightSum);
			if (leftSum == rightSum) {
				System.out.println("YES");
				has = true;
				break;
			}
			leftSum += integers[j];
		}
		if (!has) {
			System.out.println("NO");
		}
	}
}
