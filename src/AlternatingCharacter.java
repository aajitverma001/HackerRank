import java.util.Scanner;


public class AlternatingCharacter {
	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int _l;
		_l = Integer.parseInt(in.nextLine());
		String [] testCases = new String[_l];
		for (int i = 0; i < _l; i++) {
			testCases[i] = in.nextLine();
		}
		getResult(testCases);
    }

	private static void getResult(String[] testCases) {
		for (int i = 0; i < testCases.length; i++) {
			char [] str = testCases[i].toCharArray();
			char currentChar = str[0];
			int delete = 0;
			for (int j = 1; j < str.length; j++) {
				if(currentChar == str[j]){
					delete++;
				}else{
					currentChar = str[j];
				}
			}
			System.out.println(delete);
		}
		
	}
}
