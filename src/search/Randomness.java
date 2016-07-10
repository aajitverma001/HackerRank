package search;

import java.util.Arrays;
import java.util.Scanner;
//inefficient
public class Randomness {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inp = sc.nextLine();
		int q = Integer.parseInt(inp.split(" ")[1]);
		String str = sc.nextLine();
		int[] p = new int[q];
		char[] c = new char[q];
		for (int i = 0; i < q; i++) {
			inp = sc.nextLine();
			p[i] = Integer.parseInt(inp.split(" ")[0]);
			c[i] = inp.split(" ")[1].toCharArray()[0];
		}
		long time = System.currentTimeMillis(); 
		for (int i = 0; i < q; i++) {
			char[] sArr = str.toCharArray();
			sArr[p[i]-1] = c[i];
			str = new String(sArr);
			System.out.println(uniqueSubstring(str));
		}
		System.out.println(System.currentTimeMillis() - time +" time");
	}

	static long uniqueSubstring(String string) {
		int l = string.length();
		String[] prefixArr = new String[l];
		for (int i = 0; i < l; ++i) {
			prefixArr[i] = string.substring(l - 1 - i, l);
		}
		Arrays.sort(prefixArr);
		long numOfSubstring = prefixArr[0].length();
		for (int i = 0; i < l - 1; ++i) {
			int j = 0;
			for (; j < prefixArr[i].length(); ++j) {
				if (!((prefixArr[i].substring(0, j + 1))
						.equals((prefixArr)[i + 1].substring(0, j + 1)))) {
					break;
				}
			}
			numOfSubstring += prefixArr[i + 1].length() - j;
		}
		return numOfSubstring;
	}
}
