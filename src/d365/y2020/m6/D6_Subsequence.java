package d365.y2020.m6;

/*
 * A subsequence of a string is a new string which is formed from the original string 
 * by deleting some (can be none) of the characters without disturbing the relative 
 * positions of the remaining characters. 
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * 
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * 
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 */

public class D6_Subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "abc", t = "ahbgdc";
		System.out.println(isSubsequence(s, t));
	}
	
	public static boolean isSubsequence(String s, String t) {
        
        int m = s.length();
        int n = t.length();
        int i = 0, j = 0;
        
        while(i < m && j < n) {
            if(s.charAt(i) == t.charAt(j)) i ++;
            j ++;
        }
        return i == m;
    }

}
