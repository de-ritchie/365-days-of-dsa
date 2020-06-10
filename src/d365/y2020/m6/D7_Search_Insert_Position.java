package d365.y2020.m6;

public class D7_Search_Insert_Position {

	/*
	 * Given a sorted array and a target value, return the index if the target is found. 
	 * If not, return the index where it would be if it were inserted in order.
	 * You may assume no duplicates in the array.
	 * 
	 * Example 1:
	 * Input: [1,3,5,6], 5
	 * Output: 2
	 * 
	 * Example 2:
	 * Input: [1,3,5,6], 2
	 * Output: 1
	 * 
	 * Example 3:
	 * Input: [1,3,5,6], 7
	 * Output: 4
	 * 
	 * Example 4:
	 * Input: [1,3,5,6], 0
	 * Output: 0
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int n = nums.length - 1;
        int end = n;
        int mid = 0;
        while(start <= end && start <= n && end >= 0) {
            mid = start + ((end - start)/2);
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return (nums[mid] < target)?mid + 1:mid;
    }

}
