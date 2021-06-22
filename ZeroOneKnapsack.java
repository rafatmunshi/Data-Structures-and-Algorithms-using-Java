package ds;

import java.util.HashSet;
// This is Top Down
public class ZeroOneKnapsack {
		static int count=0;
		static int C=4;
	  public static void main(String[] args) {
	    int[] values = {1, 6, 10};
	    int[] weights = {1, 2, 3};
	    HashSet<Integer> takenItems= new HashSet<Integer>();
	    int maxProfit = maxProfit(values, weights, C, takenItems);
	    System.out.println("Max Profit that could be gained " + maxProfit);
	    System.out.println("The Selected items are");
	    takenItems.forEach(System.out::println);
	  }

	static private int maxProfit(int[] values, int[] weights, int C, HashSet<Integer> takenItems) {
		Integer [][] dp= new Integer[values.length][C+1];
		return maxProfitRecursive(values, weights, C, 0, dp, takenItems);
	}

	static private int maxProfitRecursive(int[] values, int[] weights, int remCap, int currItem, Integer [][] dp, HashSet<Integer> takenItems) {
//		System.out.println(++count);
		if(remCap<=0|| currItem >=values.length)
			return 0;
		
		if(dp[currItem][remCap]!=null)
			return dp[currItem][remCap];
		
		int maxProfit1=0;
		int maxProfit2=0;
		
			if(weights[currItem] <= remCap) {
				maxProfit1= values[currItem] + maxProfitRecursive(values, weights, remCap-weights[currItem], currItem+1, dp, takenItems);

			}
			maxProfit2= maxProfitRecursive(values, weights, remCap, currItem+1, dp, takenItems);
			dp[currItem][remCap]= Math.max(maxProfit1, maxProfit2);
			if(maxProfit1>maxProfit2)
				takenItems.add(currItem+1);
			
//			for(int i=0; i<values.length; i++) {
//				for(int j=0; j<C+1; j++) {
//					System.out.print(" "+dp[i][j]);
//				}
//				System.out.println();
//			}
			return dp[currItem][remCap];
	}
}
