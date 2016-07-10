import java.util.Scanner;

public class SquareNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		String[] inp = new String[t];
		for (int i = 0; i < inp.length; i++) {
			inp[i] = sc.nextLine();
		}
		for (int i = 0; i < inp.length; i++) {
			String[] range = inp[i].split(" ");
			long r1 = Integer.parseInt(range[0]);
			long r2 = Integer.parseInt(range[1]);
			getSquareNumber(r1, r2);
			getSquareNumber1(r1, r2);
		}
	}

	private static void getSquareNumber(long r1, long r2) {
		int count=0;
		for (long i = r1; i <= r2; i++) {
			double sqrt = Math.sqrt(i);
			long lsqrt = (long) sqrt;
			if(sqrt == lsqrt){
				count++;
			}
		}
		System.out.println(count);

	}
	
	private static void getSquareNumber1(long r1, long r2) {
		int count = 0;
		long i = 1;
		while (true) {
			long sq = i * i;
			if (sq >= r1 && sq <= r2) {
				count++;
			} else if (sq > r2) {
				break;
			}
			i++;
		}
		System.out.println(count);
	}
}
