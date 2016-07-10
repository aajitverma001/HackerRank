package combinatorics;

import java.math.BigInteger;
import java.util.Scanner;

public class Handshake {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		long[] inputs = new long[t];
		for (int i = 0; i < t; i++) {
			inputs[i] = Long.parseLong(sc.nextLine());
		}
		for (int i = 0; i < inputs.length; i++) {
			System.out.println((BigInteger.valueOf(inputs[i])
					.multiply(BigInteger.valueOf(inputs[i] - 1)))
					.divide(BigInteger.valueOf(2)));
		}
	}

}
