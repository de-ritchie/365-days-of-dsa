package d365.y2020.m6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Suppose you have a random list of people standing in a queue. 
 * Each person is described by a pair of integers (h, k), 
 * where h is the height of the person and k is the number of people 
 * in front of this person who have a height greater than or equal to h. 
 * Write an algorithm to reconstruct the queue.
 * 
 * Note: 
 * The number of people is less than 1,100.
 * 
 * Example
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */

public class D4_Queue_Reconstruct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] a, int b[]) {
				if(a[0] == b[0]) {
					return Integer.compare(a[1], b[1]);
				}
				return -1 * Integer.compare(a[0], b[0]);
			}
		});
		for(int i = 0; i < arr.length; i ++) {
			for(int j: arr[i]) System.out.print(j+" ");
			System.out.println();
		}
		List<int[]> list = new ArrayList<int[]>();
		for(int i = 0; i < arr.length; i ++) {
			list.add(arr[i][1], arr[i]);
		}
		System.out.println();
		int[][] result = list.toArray(new int[arr.length][2]);
		for(int i = 0; i < result.length; i ++) {
			for(int j: result[i]) System.out.print(j+" ");
			System.out.println();
		}
		System.out.println("======");
		for(int[] i: result) {
			for(int j: i) System.out.print(j+" ");
			System.out.println();
		}
	}

}
