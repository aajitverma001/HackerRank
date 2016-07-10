import java.util.Scanner;

public class SherlockAndQueries {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		String[] aStr = sc.nextLine().split(" ");
		String[] bStr = sc.nextLine().split(" ");
		String[] cStr = sc.nextLine().split(" ");
		long[] a = new long[N];
		for (int i = 0; i < N; i++) {
			a[i] = Long.parseLong(aStr[i]);
		}
		long[] b = new long[M];
		long[] c = new long[M];
		for (int i = 0; i < M; i++) {
			b[i] = Long.parseLong(bStr[i]);
			c[i] = Long.parseLong(cStr[i]);
		}
		genResult(N, M, a, b, c);

	}

	private static void genResult(int n, int m, long[] a, long[] b, long[] c) {
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (j % b[i] == 0) {
					a[j] = (a[j] % 1000000007 * c[i] %1000000007) % 1000000007;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(a[i]);
			System.out.print(" ");
		}
	}
}
