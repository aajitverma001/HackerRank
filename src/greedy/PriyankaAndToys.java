package greedy;

import java.util.*;

/*
 Problem Statement

 Little Priyanka visited a kids' shop. There are N toys and their weight is represented by an array W=[w1,w2,…,wN]. Each toy costs 1 unit, and if she buys a toy with weight w′, then she can get all other toys whose weight lies between [w′,w′+4] (both inclusive) free of cost.

 Input Format

 The first line contains an integer N i.e. number of toys.
 Next line will contain N integers, w1,w2,…,wN, representing the weight array.

 Output Format

 Minimum units with which Priyanka could buy all of toys.

 Constraints 
 1≤N≤105
 0≤wi≤104,where i∈[1,N]
 
 Sample Input

 5
 1 2 3 17 10
 
 Sample Output

 3
 Explanation

 She buys 1st toy with weight 1 for 1 unit and gets 2nd and 3rd toy for free since their weight lies between [1,5]. And she has to buy last two toys separately.
 */
public class PriyankaAndToys {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String[] inp = sc.nextLine().split(" ");
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(inp[i]);
		}
		// logic starts here
		Arrays.sort(arr);
		int i = 0;
		int currentMinUnit = 1;
		int bestMinUnit = Integer.MAX_VALUE;
		int[] backTrack = new int[N];
		for (; i < arr.length; i++) {
			int w = arr[i] + 4;
			int j = i + 1;
			while (j < arr.length && arr[j] <= w) {
				j++;
			}
			backTrack[i] = j;
			currentMinUnit += arr.length - j;
			int k = 0;
			while (k < i) {
				k = backTrack[k];
				currentMinUnit++;
			}
			if (currentMinUnit < bestMinUnit) {
				bestMinUnit = currentMinUnit;
			}
			currentMinUnit = 1;
		}
		System.out.println(bestMinUnit);
	}
}
