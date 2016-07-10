package cryptography;

import java.util.*;

public class PRNGSequenceGuessing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		long[][] seedData = new long[t][2];
		int[][] inpSeq = new int[t][10];
		for (int i = 0; i < t; i++) {
			String inp = sc.nextLine();
			seedData[i][0] = Long.parseLong(inp.split(" ")[0]);
			seedData[i][1] = Long.parseLong(inp.split(" ")[1]);
			for (int j = 0; j < 10; j++) {
				inpSeq[i][j] = Integer.parseInt(sc.nextLine());
			}
		}
		for (int i = 0; i < t; i++) {
			processSequence(seedData[i][0], seedData[i][1], inpSeq[i]);
			System.out.println();
		}

	}

	private static void processSequence(long l, long m, int[] is) {
		for (long i = l; i <= m; i++) {
			Random generator = new Random(i);
			Integer gen = null;
			int j = 0;
			for (; j < is.length; j++) {
				gen = generator.nextInt(1000);
				if (gen != is[j]) {
					break;
				}
			}
			if (j == 10) {
				System.out.print(i);
				int count = 0;
				while (count < 10) {
					gen = generator.nextInt(1000);
					System.out.print(" " + gen);
					count++;
				}
				break;
			}
		}
	}
}
