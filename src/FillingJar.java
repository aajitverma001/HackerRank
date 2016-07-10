import java.util.Scanner;

public class FillingJar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nm = sc.nextLine();
		int n = Integer.parseInt(nm.split(" ")[0]);
		int m = Integer.parseInt(nm.split(" ")[1]);
		long[][] opo = new long[m][3];
		long total = 0;
		for (int i = 0; i < m; i++) {
			String o = sc.nextLine();
			opo[i][0] = Long.parseLong(o.split(" ")[0]);
			opo[i][1] = Long.parseLong(o.split(" ")[1]);
			opo[i][2] = Long.parseLong(o.split(" ")[2]);
			total+= (opo[i][1] - opo[i][0] + 1) * opo[i][2];
		}
		double avg = total / n;
		Long ans = ((Double) Math.floor(avg)).longValue();
		System.out.println(ans);
	}
}
