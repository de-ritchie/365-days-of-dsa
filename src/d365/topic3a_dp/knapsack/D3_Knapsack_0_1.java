package d365.topic3a_dp.knapsack;

/*
 * Given the weights and profits of ‘N’ items, 
 * we are asked to put these items in a knapsack which has a capacity ‘C’. 
 * The goal is to get the maximum profit from the items in the knapsack. 
 * Each item can only be selected once, as we don’t have multiple quantities of any item.
 * 
 * Input:
 * Items: { Apple, Orange, Banana, Melon }
 * Weights: { 2, 3, 1, 4 }
 * Profits: { 4, 5, 3, 7 }
 * Knapsack capacity: 5
 * 
 * Output: Banana + Melon (total weight 5) => 10 profit
 * 
 * Explaination:
 * Apple + Orange (total weight 5) => 9 profit
 * Apple + Banana (total weight 3) => 7 profit
 * Orange + Banana (total weight 4) => 8 profit
 * Banana + Melon (total weight 5) => 10 profit
 */

public class D3_Knapsack_0_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] profits = {1, 6, 10, 16};//{4, 5, 3, 7};//{1, 6, 10, 16};
	    int[] weights = {1, 2, 3, 5};//{2, 3, 1, 4};//{1, 2, 3, 5};
	    int capacity = 7;//5;
	    int n = profits.length;
	    int dp[][] = new int[capacity+1][n];
	    for(int i = 0; i <= capacity; i ++)
	    	for(int j = 0; j < n; j ++)
	    		dp[i][j] = -1;
	    System.out.println(recurs(profits, weights, capacity, 0, n));
	    recursMemo(profits, weights, capacity, 0, n, dp);
	    for(int[] i: dp) {
	    	for(int j: i) System.out.print(j+" ");
	    	System.out.println();
	    }
	    System.out.println(dp[capacity][0]);
	    System.out.println(dp(profits, weights, n, capacity));
	    System.out.println(optimizedDP(profits, weights, n, capacity));
	}
	
	public static int recurs(int [] profits, int[] weights, 
			int capacity, int index, int n) {
		
		//O(2^n)
		if(index == n) return 0;
		if(capacity == 0) return 0;
		
		int inc = 0, exc = 0;
		if(capacity - weights[index] >= 0) {
			inc = profits[index] + 
			recurs(profits, weights, capacity - weights[index], index + 1, n);
		}
		exc = recurs(profits, weights, capacity, index + 1, n);
		return Math.max(inc, exc);
	}
	
	public static int recursMemo(int [] profits, int[] weights, 
			int capacity, int index, int n, int dp[][]) {
		
		//Time O(N*C) & Space O(N*C)
		if(index == n) return 0;
		if(capacity == 0) return 0;
		
		if(dp[capacity][index] != -1) return dp[capacity][index];
		int inc = 0, exc = 0;
		if(capacity - weights[index] >= 0) {
			inc = profits[index] + 
			recurs(profits, weights, capacity - weights[index], index + 1, n);
		}
		exc = recurs(profits, weights, capacity, index + 1, n);
		dp[capacity][index] = Math.max(inc, exc);
		return dp[capacity][index];
	}
	
	public static int dp(int[] profits, int[] weights, int n, int capacity) {
		
		//Time O(N*C) & Space O(N*C)
		int dp[][] = new int [n][capacity + 1];
		for(int i = 0; i < n; i ++) dp[i][0] = 0;
		for(int i = 0; i < n; i ++) {
			for(int j = 1; j <= capacity; j ++) {
				if(weights[i] <= j) {
					if(i > 0)
						dp[i][j] = Math.max(dp[i-1][j], profits[i]+dp[i - 1][j - weights[i]]);
					else dp[i][j] = profits[i];
				} else {
					if(i > 0)
						dp[i][j] = dp[i-1][j];
					else dp[i][j] = 0;
				}
			}
		}
		for(int[]i: dp) {
			for(int j: i) System.out.print(j+" ");
			System.out.println();
		}
		return dp[n-1][capacity];
	}

	public static int optimizedDP(int[] profits, int[] weights, int n, int capacity) {
		
		//Time O(N*C) & Space O(C)
		int[] dp = new int[capacity+1];
		for(int j = 0; j <= capacity; j ++) {
			int max = 0;
			for(int i = 0; i < n; i ++) {
				
				if(j >= weights[i]) {
					int diff = j - weights[i];
					int tmp = (diff < weights[i])?dp[diff]:0;
					max = Math.max(max, profits[i]+tmp);
				}
			}
			dp[j] = max;
		}
		System.out.println("Opt O(C) space");
		for(int i: dp) System.out.print(i+" ");
		System.out.println();
		return dp[capacity];
	}
	
}
