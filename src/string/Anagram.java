package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// incorrect
public class Anagram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		String[] inp = new String[T];
		for (int i = 0; i < inp.length; i++) {
			inp[i] = sc.nextLine();
		}
		convToAnagram(inp);
	}

	private static void convToAnagram(String[] inp) {
		for (int i = 0; i < inp.length; i++) {
			String s = inp[i];
			if (s.length() % 2 != 0) {
				System.out.println(-1);
				continue;
			}
			Map<String, Integer> c1 = charCounter(s
					.substring(0, s.length() / 2));
			Map<String, Integer> c2 = charCounter(s.substring(s.length() / 2));
			int count = 0;
			for (Map.Entry<String, Integer> e : c1.entrySet()) {
				if (c2.containsKey(e.getKey())) {
					count++;
				}
			}

			System.out.println((s.length()/2) - count);
		}

	}

	static Map<String, Integer> charCounter(String inputString) {
		Map<String, Integer> charCount = new HashMap<String, Integer>();
		for (int i = 0; i < inputString.length(); i++) {
			String c = String.valueOf(inputString.charAt(i));
			if (charCount.containsKey(c)) {
				charCount.put(c, charCount.get(c) + 1);
			} else {
				charCount.put(c, 1);
			}
		}
		return charCount;
	}
}
