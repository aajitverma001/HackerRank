package string;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MakeItAnagram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inp1 = sc.nextLine();
		String inp2 = sc.nextLine();
		Map<String, Integer> c1 = charCounter(inp1);
		Map<String, Integer> c2 = charCounter(inp2);
		int count = 0;
		for (Map.Entry<String, Integer> e : c1.entrySet()) {
			if (c2.containsKey(e.getKey())) {
				int i = c2.get(e.getKey()) - e.getValue();
				if (i < 0) {
					i = i * (-1);
				}
				count += i;
			} else {
				count += e.getValue();
			}
		}
		for (Map.Entry<String, Integer> e : c2.entrySet()) {
			if (!c1.containsKey(e.getKey())) {
				count += e.getValue();
			}
		}
		System.out.println(count);
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
