package cryptography;

import java.util.*;

public class TranspositionChipher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		String[] cipherKey = new String[t];
		String[] cipherText = new String[t];
		for (int i = 0; i < t; i++) {
			cipherKey[i] = sc.nextLine();
			cipherText[i] = sc.nextLine();
		}
		for (int i = 0; i < t; i++) {
			Map<String, String> substitution = processCipherKey(cipherKey[i]);
			String str = cipherText[i];
			StringBuilder decript = new StringBuilder();
			for (int j = 0; j < str.length(); j++) {
				String key = String.valueOf(str.charAt(j));
				if (substitution.containsKey(key)) {
					decript.append(substitution.get(key));
				} else {
					decript.append(key);
				}
			}
			System.out.println(decript);
		}
	}

	private static Map<String, String> processCipherKey(String string) {
		Map<String, String> substitution = new HashMap<String, String>();
		StringBuilder str = new StringBuilder();
		ArrayList<String> chars = new ArrayList<String>();
		for (int i = 65; i < 91; i++) {
			chars.add(String.valueOf((char) i));
		}
		ArrayList<String> pool = new ArrayList<String>();
		for (int i = 0; i < string.length(); i++) {
			if (!pool.contains(String.valueOf(string.charAt(i)))) {
				pool.add(String.valueOf(string.charAt(i)));
				str.append(string.charAt(i));
				chars.remove(String.valueOf(string.charAt(i)));
			}
		}
		char[] sortedStr = str.toString().toCharArray();
		Arrays.sort(sortedStr);
		int c = str.length();
		int r = 26 / c;
		r = 26 % c == 0 ? r : r + 1;
		String[][] s = new String[r][c];
		int count = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (i == 0) {
					s[i][j] = String.valueOf(str.charAt(j));
				} else {
					s[i][j] = chars.get(count);
					count++;
					if (count >= chars.size()) {
						break;
					}
				}
			}
		}
		count = 0;
		int asc = 65;
		while (count < c) {
			int j = pool.indexOf(String.valueOf(sortedStr[count]));
			for (int i = 0; i < r; i++) {
				String value = s[i][j];
				if (value != null) {
					substitution.put(value, String.valueOf(((char) asc)));
					asc++;
				}
			}
			count++;
		}
		return substitution;
	}
}
