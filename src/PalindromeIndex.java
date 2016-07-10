import java.util.*;

public class PalindromeIndex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<String> inp = new ArrayList<String>();
		for (int i = 0; i < t; i++) {
			inp.add(sc.nextLine());
		}
		getResult(t, inp);
	}

	private static void getResult(int t, List<String> inp) {
		for (int i = 0; i < t; i++) {
			String str = inp.get(i);
			int l = str.length();
			int hl = (l / 2);
			int j = 0, k = l - 1, index = -1;
			while (j <= hl && hl <= k) {
				if (str.substring(0, hl).equals(reverse(str.substring(l - hl)))) {
					break;
				}
				if (str.charAt(j) != str.charAt(k)) {
					String rmj = str.substring(0, j).concat(
							str.substring(j + 1));
					int lj = rmj.length();
					int hlj = lj / 2;
					if (rmj.substring(0, hlj).equals(
							reverse(rmj.substring(lj - hlj)))) {
						index = j;
						break;
					}
					String rmk = str.substring(0, k).concat(
							str.substring(k + 1));
					int lk = rmj.length();
					int hlk = lk / 2;
					if (rmk.substring(0, hlk).equals(
							reverse(rmk.substring(lk - hlj)))) {
						index = k;
						break;
					}
				}
				j++;
				k--;
			}
			System.out.println(index);

		}
	}

	private static String reverse(String str) {
		StringBuffer sb = new StringBuffer(str);
		return sb.reverse().toString();
	}
}
