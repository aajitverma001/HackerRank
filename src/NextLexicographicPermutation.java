import java.util.*;
import java.util.Arrays;
import java.util.Scanner;

public class NextLexicographicPermutation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		String[] inputs = new String[t];
		for (int i = 0; i < t; i++) {
			inputs[i] = sc.nextLine();
		}
		for (int i = 0; i < t; i++) {
//			genNextPermutationNPrint(inputs[i]);
//			permutation(inputs[i]);
		}
		getRank(inputs);
	}

	static int[] getRank(String[] words) {
		int[] arr = new int[words.length];
		for (int i = 0; i < arr.length; i++) {
			String s = words[i];
			int rank = 1;
			long modulo = 1000000007;
			int permCount = 1;
			Map<Character, Integer> charPool = new HashMap<Character, Integer>();
			for (int ik = s.length() - 1; ik > -1; ik--) {
				System.out.println("ik"+ ik);
				char x = s.charAt(ik);
				int xCount = charPool.containsKey(x) ? charPool.get(x) + 1 : 1;
				charPool.put(x, xCount);
				System.out.println(charPool);
				for (java.util.Map.Entry<Character, Integer> e : charPool
						.entrySet()) {
					if (e.getKey() < x) {
						Long num = (Long) ((permCount % modulo * e.getValue() % modulo) % modulo)
								* findMMI_fermat(xCount, modulo) % modulo;
						rank = rank + num.intValue();
					}
				}
				System.out.println("prem " + permCount);
				permCount = permCount * s.length() - ik;
				permCount = permCount / xCount;
				System.out.println("prem " + permCount);
			}
			rank--;
			System.out.println(rank);
			arr[i] = rank;
		}
		return arr;
	}

	static void genNextPermutationNPrint(String s) {
		int pivot = 0;
		String suffix = "";
		if (s.length() == 1) {
			System.out.println("no answer");
			return;
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			suffix = s.charAt(i) + suffix;
			if (i - 1 < 0) {
				System.out.println("no answer");
				return;
			}
			if (s.charAt(i - 1) >= s.charAt(i)) {
				continue;
			}
			pivot = i - 1;
			break;
		}
		char[] prefix = (s.substring(0, pivot + 1)).toCharArray();
		char[] arr = suffix.toCharArray();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > s.charAt(pivot)) {
				char temp = arr[i];
				arr[i] = prefix[prefix.length - 1];
				prefix[prefix.length - 1] = temp;
				break;
			}
		}
		System.out.println(new String(prefix).concat(new String(arr)));

	}

	static String genNextPermutation(String s) {
		int pivot = 0;
		String suffix = "";
		if (s.length() == 1) {
			return s;
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			suffix = s.charAt(i) + suffix;
			if (i - 1 < 0) {
				return s;
			}
			if (s.charAt(i - 1) >= s.charAt(i)) {
				continue;
			}
			pivot = i - 1;
			break;
		}
		char[] prefix = (s.substring(0, pivot + 1)).toCharArray();
		char[] arr = suffix.toCharArray();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > s.charAt(pivot)) {
				char temp = arr[i];
				arr[i] = prefix[prefix.length - 1];
				prefix[prefix.length - 1] = temp;
				break;
			}
		}
		return new String(prefix).concat(new String(arr));

	}

	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1, n));
		}
	}

	private static long fast_pow(long base, long n, long M) {
		if (n == 0)
			return 1;
		if (n == 1)
			return base;
		long halfn = fast_pow(base, n / 2, M);
		if (n % 2 == 0)
			return (halfn * halfn) % M;
		else
			return (((halfn * halfn) % M) * base) % M;
	}

	private static long findMMI_fermat(long n, long M) {
		return fast_pow(n, M - 2, M);
	}

}
