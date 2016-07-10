package search;

import java.util.Scanner;

public class Encription {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		double sq = Math.sqrt(in.length());
		int r = ((Double) Math.floor(sq)).intValue();
		int c = ((Double) Math.ceil(sq)).intValue();
		if (r * c < in.length() && r < c) {
			r = c;
		}
		// System.out.println(r + " " + c);
		char[] str = in.toCharArray();
		char[][] encrip = new char[r][c];
		int k = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (k >= in.length()) {
					k = -1;
					break;
				}
				encrip[i][j] = str[k];
				k++;
			}
			if (k == -1) {
				break;
			}
		}
		StringBuilder opt = new StringBuilder();
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				if(encrip[j][i] != '\u0000'){
					opt.append(encrip[j][i]);
				}
			}
			if (i < c - 1) {
				opt.append(" ");
			}
		}
		System.out.println(opt);
	}
}
