import java.util.Scanner;


public class FlippingBits {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		Long[] inp = new Long[N];
		for (int i = 0; i < inp.length; i++) {
			inp[i] = Long.parseLong(in.nextLine());
		}
		getResult(inp);
	}

	private static void getResult(Long[] inp) {
		for (int i = 0; i < inp.length; i++) {
			Long num = inp[i];
			String  bin= Long.toBinaryString(num);
			while(bin.length()<32){
				bin = "0".concat(bin);
			}
			flipNPrintDecimal(bin);
		}
	}

	private static void flipNPrintDecimal(String bin) {
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < bin.length(); i++) {
			if(bin.charAt(i) == '1'){
				buff.append(0);
			} else {
				buff.append(1);
			}
		}
		System.out.println(Long.parseLong(buff.toString(), 2));
	}
}
