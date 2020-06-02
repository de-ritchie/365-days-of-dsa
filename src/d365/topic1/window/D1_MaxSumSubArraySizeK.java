package d365.topic1.window;

/*
 * Given an array of positive numbers and a positive number 'k', 
 * find the maximum sum of any contiguous subarray of size 'k'.
 * 
 * Example 1:
 * Input: [2, 1, 5, 1, 3, 2], 
 * k=3 Output: 9 
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 * 
 * Example 2:
 * Input: [2, 3, 4, 1, 5], k=2 
 * Output: 7 
 * Explanation: Subarray with maximum sum is [3, 4].
 */

public class D1_MaxSumSubArraySizeK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {2, 3, 4, 1, 5};
		int k = 2;
		System.out.println(findMaxSumSubArray(k, arr));
	}
	
	public static int findMaxSumSubArray(int k, int[] nums) {
        
        int largest = Integer.MIN_VALUE;
        int len = nums.length;
        int sum = 0, kRef = k;
        for(int i = 0; i < len; i ++) {
        	if(k > 0) k --;
        	else sum -= nums[i - kRef];
        	sum += nums[i];
        	if(k == 0 && sum > largest) {
        		largest = sum;
        	}
        }
        return largest;
    }

}
