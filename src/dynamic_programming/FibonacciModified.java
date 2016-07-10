package dynamic_programming;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inp = sc.nextLine();
		int first = Integer.parseInt(inp.split(" ")[0]);
		int second = Integer.parseInt(inp.split(" ")[1]);
		int n = Integer.parseInt(inp.split(" ")[2]);
		BigInteger a = BigInteger.valueOf(first);
		BigInteger b = BigInteger.valueOf(second);
		BigInteger nterm = null;
		for (int i = 3; i <= n; i++) {
			nterm = (b.multiply(b)).add(a);
			a = b;
			b = nterm;
		}
		System.out.println(nterm);
	}
}
