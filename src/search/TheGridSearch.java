package search;

import java.util.*;

public class TheGridSearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		int[][] dimen = new int[t][2];
		List<String[]> matrix = new ArrayList<String[]>();
		int[][] subDimen = new int[t][2];
		List<String[]> subMatrix = new ArrayList<String[]>();
		for (int i = 0; i < t; i++) {
			String d = sc.nextLine();
			dimen[i][0] = Integer.parseInt(d.split(" ")[0]);
			dimen[i][1] = Integer.parseInt(d.split(" ")[1]);
			String[] mat = new String[dimen[i][0]];
			for (int j = 0; j < mat.length; j++) {
				mat[j] = sc.nextLine();
			}
			matrix.add(mat);
			String sd = sc.nextLine();
			subDimen[i][0] = Integer.parseInt(sd.split(" ")[0]);
			subDimen[i][1] = Integer.parseInt(sd.split(" ")[1]);
			String[] smat = new String[subDimen[i][0]];
			for (int j = 0; j < smat.length; j++) {
				smat[j] = sc.nextLine();
			}
			subMatrix.add(smat);
		}

		for (int i = 0; i < t; i++) {
			solve(dimen[i][0], dimen[i][1], matrix.get(i), subDimen[i][0],
					subDimen[i][1], subMatrix.get(i));
		}
	}

	private static void solve(int r, int c, String[] strings, int sr, int sc,
			String[] sstrings) {
		String ans = "NO";
		for (int i = 0; i <= r - sr; i++) {
			int match = 0;
			for (int j = 0; j < sr; j++) {
				if (strings[i + match].contains(sstrings[j])) {
					match++;
					continue;
				}
				break;
			}
			if (match == sr) {
				ans = "YES";
				break;
			}
		}
		System.out.println(ans);
	}

}
