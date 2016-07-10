package cb;


public class Question2 {
	public static void main(String[] args) {
		int[] arr = {0, -1, 5, 0, 4, 0, -9, 0};
		moveNonZeros(arr);
		System.out.print("[ ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print(" ]");
	}

	static void moveNonZeros(int[] arr) {
		int top = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != 0){
				int temp = arr[i];
				arr[i] = arr[top];
				arr[top] = temp;
				top++;
			}
		}
		
	}
}
