package d365.y2020.m6;

/*
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * Input: 1
 * Output: true 
 * Explanation: 2^0 = 1
 * 
 * Input: 16
 * Output: true
 * Explanation: 2^4 = 16
 * 
 * Input: 218
 * Output: false
 */

public class D5_PowerOf2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static boolean isPowerOf2(int n) {
		if(n<=0)
	           return false;
	       return (n&(-n)) == n;
	}

}
