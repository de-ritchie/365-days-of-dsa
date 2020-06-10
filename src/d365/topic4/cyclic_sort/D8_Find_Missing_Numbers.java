package d365.topic4.cyclic_sort;

/*
 * We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’. 
 * Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, 
 * find the missing number.
 * 
 * Example 1:
 * Input: [4, 0, 3, 1]
 * Output: 2
 * 
 * Example 2:
 * Input: [8, 3, 5, 2, 4, 6, 0, 1]
 * Output: 7
 */

public class D8_Find_Missing_Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {8, 3, 10, 9, 4, 6, 0, 1};
		int n = arr.length;
		
		for(int i = 0 ; i < n; i ++) {
			while(arr[i] != i && arr[i] < n) {
				int tmp = arr[i];
				arr[i] = arr[arr[i]];
				arr[tmp] = tmp;
			}
		}
		for(int i: arr) System.out.print(i+" ");
		System.out.println();
		for(int i = 0; i < n; i ++) {
			if(i != arr[i]) {
				System.out.println(i);
			}
		}
	}

}
