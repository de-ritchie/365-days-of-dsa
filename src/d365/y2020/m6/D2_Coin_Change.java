package d365.y2020.m6;

/*
 * You are given coins of different denominations and a total amount of money. 
 * Write a function to compute the number of combinations that make up that amount. 
 * You may assume that you have infinite number of each kind of coin.
 * 
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 
 * Input: amount = 10, coins = [10] 
 * Output: 1
 */

public class D2_Coin_Change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int den[] = {1, 2, 5};
		int amount = 10;
		int dp[][] = new int[den.length][amount+1];
		for(int i = 0; i < dp.length; i ++)
			for(int j = 0; j < dp[i].length; j ++)
				dp[i][j] = -1;
		System.out.println(dpMem(den, amount, 0, den.length, dp));
		System.out.println(dp(den, amount, den.length));
		System.out.println(optDP(den, amount, den.length));
		System.out.println(11 & -11);
	}
	
	public static int optDP(int[] dens, int amount, int n) {
		
		int dp[] = new int[amount + 1];
        dp[0] = 1;
        for(int den: dens) {
            for(int i = den; i <= amount; i ++) {
                dp[i] += dp[i-den];
            }
        }
        for(int i: dp) System.out.print(i+" ");
        System.out.println();
        return dp[amount];
	}
	
	public static int dp(int[] den, int amount, int n) {
		
		int dp[][] = new int[n+1][amount+1];
		for(int i = 0; i <= n; i ++) dp[i][0] = 1;
		
		for(int i = 1; i <= n; i ++) {
			for(int j = 1; j <= amount; j ++) {
				dp[i][j] = dp[i-1][j] + ((j>=den[i-1])?dp[i][j - den[i-1]]:0);
			}
		}
		for(int[] i: dp) {
			for(int j: i) System.out.print(j+" ");
			System.out.println();
		}
		return dp[n][amount];
	}
	
	public static int dpMem(int[] den, int amount, int index, int n, int dp[][]) {
		if(index == n) return 0;
		if(amount == 0) return 1;
		if(amount < 0) return 0;
		
		if(dp[index][amount] != -1) return dp[index][amount];
		System.out.println("index "+index+" amount "+amount);
		
		int sum = 0;
		for(int i = index; i < n; i ++) {
			int recurs = dpMem(den, amount - den[i], i, n, dp);
			sum += recurs;
		}
		dp[index][amount] = sum;
		return sum;
	}

}
