package d365.topic2.misc;

/*
 * Subsequence of bits with 1's and greater than 2
 * 
 * Input: 11011
 * Output: 11011, 1101, 1011, 110, 101, 011, 11, 11
 */

public class D1_SubseqBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "11011";
		int len = str.length();
		for(int i = len; i > 0; i --)
			slidingWindow(str, i);
	}
	
	public static void slidingWindow(String str, int k) {
		int len = str.length();
		int count1s = 0, kRef = k, start = 0;
		for(int i = 0; i < len; i ++) {
			k --;
			if(k < 0) {
				if(str.charAt(i - kRef) == '1') count1s --;
				k ++;
				start ++;
			}
			if(str.charAt(i) == '1') count1s ++;
			if(k == 0 && count1s >= 2) print(str, start, i);
		}
	}
	
	public static void print(String str, int start, int end) {
		for(int i = start; i <= end; i ++) System.out.print(str.charAt(i));
		System.out.println();
	}

}
