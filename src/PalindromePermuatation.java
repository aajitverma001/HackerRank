import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePermuatation {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = br.readLine();

			long result = getOutput(input); // Write the code to compute the
											// result here.

			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static long getOutput(String inputString) {
		Map<String, Integer> charCount = new HashMap<String, Integer>();
		for (int i = 0; i < inputString.length(); i++) {
			String c = String.valueOf(inputString.charAt(i));
			if (charCount.containsKey(c)) {
				charCount.put(c, charCount.get(c) + 1);
			} else {
				charCount.put(c, 1);
			}
		}
		int oddCount = 0;
		StringBuffer permString = new StringBuffer();
		List<Integer> repeatedCount = new ArrayList<Integer>();
		for (Map.Entry<String, Integer> en : charCount.entrySet()) {
			if (en.getValue() % 2 != 0) {
				oddCount++;
			}
			int n = en.getValue() / 2;
			repeatedCount.add(n);
			permString
					.append(new String(new char[n]).replace("\0", en.getKey()));

		}
		long count = calculatePermCount(permString, repeatedCount);
		// System.out.println(count);
		return count;
	}

	private static long calculatePermCount(StringBuffer permString,
			List<Integer> repeatedCount) {
		long modulo = 1000000007; // (10^9 + 7)
		long numerator = moduloFactorial(permString.length(), modulo);
		long demnominator = 1;
		for (Integer integer : repeatedCount) {
			demnominator = demnominator * moduloFactorial(integer, modulo)
					% modulo;
		}
		return numerator * findMMI_fermat(demnominator, modulo) % modulo;
	}

	private static long moduloFactorial(long N, long modulo) {
		long fact = 1;
		for (long i = 1; i <= N; i++) {
			fact = fact * i % modulo;
		}
		return fact;
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

	private static long fastPow(long base, long n, long m) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return base;
		}
		long halfN = fast_pow(base, n / 2, m);
		if (n % 2 == 0) {
			return (halfN * halfN) % m;
		} else {
			return (((halfN * halfN) % m) * base) % m;
		}
	}
}
