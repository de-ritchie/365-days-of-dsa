package d365.topic3b_dp.lcs;

/*
 * Given two strings ‘s1’ and ‘s2’, find the length of the longest substring 
 * which is common in both the strings.
 * 
 * Example 1:
 * Input: s1 = "abdca"
 * s2 = "cbda"
 * Output: 2
 * Explanation: The longest common substring is "bd".
 * 
 * Example 2:
 * Input: s1 = "passport"
 * s2 = "ppsspt"
 * Output: 3
 * Explanation: The longest common substring is "ssp".
 */

public class D3_LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "passport", s2 = "ssp";
		System.out.println(recurs(s1, s2, 0, 0, s1.length(), s2.length()));
	}
	
	public static int recurs(String s1, String s2, int i, int j, int m, int n) {
		
		if(i >= m || j >= n) return 0;
		
		int max = 0;
		while(i < m && j < n && s1.charAt(i) != s2.charAt(j)) {
			max ++;
			i ++;
			j ++;
		}
		int l1 = m - i;
		int l2 = n -j;
		if(l1 > l2) {
			max = Math.max(max, recurs(s1, s2, i + 1, j, m, n));
		} else if(l1 < l2) {
			max = Math.max(max, recurs(s1, s2, i, j + 1, m, n));
		} else {
			max = Math.max(max, recurs(s1, s2, i + 1, j, m, n));
			max = Math.max(max, recurs(s1, s2, i, j + 1, m, n));
		}
		System.out.println("s1 "+s1.substring(i, m)+" s2 "+s2.substring(j, n)+" max "+max);
		return max;
	}

}
