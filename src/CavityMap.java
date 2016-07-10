import java.util.*;

public class CavityMap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String[][] map = new String[N][N];
		for (int i = 0; i < N; i++) {
			char[] mapEl = sc.nextLine().toCharArray();
			int j = 0;
			while (j < N) {
				map[i][j] = String.valueOf(mapEl[j]);
				j++;
			}
		}
		genCavityMap(map, N);
	}

	private static void genCavityMap(String[][] map, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(map[i][j]);
				String cm = null;
				if (i > 0 && i < (N - 1) && j > 0 && j < (N - 1)
						&& num > Integer.parseInt(map[i - 1][j])
						&& num > Integer.parseInt(map[i][j - 1])
						&& num > Integer.parseInt(map[i][j + 1])
						&& num > Integer.parseInt(map[i + 1][j])) {
					cm = "X";
				}
				if (cm == null) {
					System.out.print(map[i][j]);
				} else {
					System.out.print(cm);
				}
			}
			System.out.println();
		}
	}
}
