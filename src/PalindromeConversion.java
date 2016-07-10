import java.util.Scanner;

public class PalindromeConversion {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int l = Integer.parseInt(s.nextLine());
		String[] words = new String[l];
		for (int i = 0; i < words.length; i++) {
			words[i] = s.nextLine();
		}
		genResult(words);
	}

	private static void genResult(String[] words) {
		for (String word : words) {
			char[] w = word.toCharArray();
			int len = w.length;
			int middle = len / 2;
			if (len % 2 != 0) {
				middle++;
			}
			int operationCount = 0;
			for (int i = 0; i < middle; i++) {
				if (w[i] == w[len - (i + 1)]) {
					continue;
				}
				if (w[i] > w[len - (i + 1)]) {
					operationCount = difference(w[len - (i + 1)], w[i],
							operationCount);
				} else {
					operationCount = difference(w[i], w[len - (i + 1)],
							operationCount);
				}
			}
			System.out.println(operationCount);
		}
	}

	private static int difference(char a, char b, int count) {
		if (a == b) {
			return count;
		}
		b = (char) (b - 1);
		count++;
		return difference(a, b, count);
	}
}
