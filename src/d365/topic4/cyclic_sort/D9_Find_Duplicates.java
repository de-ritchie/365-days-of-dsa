package d365.topic4.cyclic_sort;

/*
 * We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. 
 * The array has some duplicates, find all the duplicate numbers without using any extra space.
 * 
 * Example 1:
 * Input: [3, 4, 4, 5, 5]
 * Output: [4, 5]
 * 
 * Example 2:
 * Input: [5, 4, 7, 2, 3, 5, 3]
 * Output: [3, 5]
 */

public class D9_Find_Duplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {5, 4, 7, 2, 3, 5, 3};
		int len = arr.length;
		for(int i = 0; i < len; i ++) {
			while(arr[i] != i - 1 && arr[i] != arr[arr[i] - 1]) {
				int tmp = arr[i];
				arr[i] = arr[tmp - 1];
				arr[tmp - 1] = tmp;
			}
		}
		for(int i: arr) System.out.print(i+" ");
		System.out.println();
		for(int i = 0; i < len; i ++) {
			if(arr[i] - 1 != i) System.out.println(arr[i]);
		}
	}

}
