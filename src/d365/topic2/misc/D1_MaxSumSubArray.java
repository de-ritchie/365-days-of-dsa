package d365.topic2.misc;

import java.util.Date;

//Reference https://leetcode.com/problems/maximum-subarray/
/*
 * Given an integer array nums, 
 * find the contiguous subarray (containing at least one number) 
 * which has the largest sum and return its sum.
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4], 
 * Output: 6 
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 0 	1	 2	3	 4	5	6	 7	8
 * -2	1	-3	4	-1	2	1	-5	4
 */

public class D1_MaxSumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
		Date d1 = new Date();
		
		System.out.println(d1.getTime());
		System.out.println(maxSubArray(nums));
		System.out.println((new Date()).getTime());
		
		d1 = new Date();
		System.out.println(d1.getTime());
		System.out.println(maxSubArrayN(nums));
		System.out.println((new Date()).getTime());
		
		System.out.println(maxSubArrayDP(nums, 0, nums.length - 1));
	}
	
	public static int maxSubArrayN(int[] nums) {
		
		int max = nums[0], curr = nums[0], len = nums.length;
		for(int i = 1; i < len; i ++) {
			if(curr < 0) curr = nums[i];
			else curr += nums[i];
			max = Math.max(max, curr);
		}
		return max;
	}
	
	public static int maxSubArray(int[] nums) {
        
		//O(N*N)
		int len = nums.length, largest = Integer.MIN_VALUE;
		
        for(int i = len; i > 0; i --) 
        	largest = Math.max(largest, slidingWindow(nums, i));
        return largest;
    }
	
	public static int slidingWindow(int arr[], int k) {
		
		int len = arr.length, kRef = k, sum = 0, largest = Integer.MIN_VALUE;
		
		for(int i = 0; i < len; i ++) {
			k --;
//			System.out.println("b4 k "+kRef+" k "+k+" i "+i+" arr[i] "+arr[i]+" sum "+sum);
			if(k < 0) {
				sum -= arr[i - kRef];
				k ++;
			}
			sum += arr[i];
//			System.out.println("a4 k "+kRef+" k "+k+" i "+i+" arr[i] "+arr[i]+" sum "+sum);
			if(k == 0 && largest < sum) {
				largest = sum;
//				System.out.println("k "+kRef+" sum "+sum);
			}
		}
		return largest;
	}
	
	public static int maxSubArrayDP(int[] nums, int start, int end) {
		
		int max = nums[end];
		int[] dp = new int[end+1];
		dp[end] = max;
		
		for(int i = end - 1; i >= start; i --) {
			int a = nums[i] + dp[i + 1];
			int b = nums[i];
			dp[i] = Math.max(a, b);
			max = Math.max(max, dp[i]);
		}
		for(int i: dp) System.out.print(i+" ");
		System.out.println();
		return max;
	}
	
	
	public static int maxSubArrayMeomoDP(int[] nums, int start, int end) {
		if(start > end) return Integer.MIN_VALUE;
		int a = nums[start] + maxSubArrayMeomoDP(nums, start + 1, end);
		int b = nums[start];
		System.out.println("a "+a+" b "+b+" start "+start+" nums[start] "+nums[start]);
		return Math.max(a, b);
	}
	

}
