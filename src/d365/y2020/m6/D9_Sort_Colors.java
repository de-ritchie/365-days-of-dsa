package d365.y2020.m6;

/*
 * Given an array with n objects colored red, white or blue, sort them in-place so that 
 * objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue 
 * respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 * 
 * Example:
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with 
 * total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */

public class D9_Sort_Colors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {2,0,2,1,1,0};
		int n = arr.length;
        if(n == 0) return;
        int minIndex = 0, maxIndex = n - 1;
        for(int i = 0; i < n; ) {
            if(arr[i] == 0) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
                minIndex ++;
                i ++;
            } else if(arr[i] == 2 && maxIndex > i) {
                int tmp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = tmp;
                maxIndex --;
                // i --;
            } else i ++;
        }
        for(int i: arr) System.out.print(i+" ");
        System.out.println();
	}

}