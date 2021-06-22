package ds;

import java.util.HashSet;

public class BottomUpDPKnapsack {
	static int count=0;
	static int C=4;
	
  public static void main(String[] args) {
    int[] values = {1, 6, 10};
    int[] weights = {1, 2, 3};
    HashSet<Integer> takenItems= new HashSet<Integer>();
    int maxProfit = maxProfit(values, weights, 4, takenItems);
    System.out.println("Max Profit that could be gained " + maxProfit);
    System.out.println("The Selected items are");
    takenItems.forEach(System.out::println);
  }

private static int maxProfit(int[] values, int[] weights, int remCap, HashSet<Integer> takenItems) {
	if(remCap<=0 || values.length==0 || weights.length!=values.length)
	return 0;
	
	int n= values.length;
	int dp[][]= new int [n][remCap+1];
	// updating the base case of first column
	for(int i=0; i<n; i++)
		dp[i][0]=0;
	
//	for(int i=0; i<n; i++) {
//		for(int j=0; j<=remCap; j++) {
//			System.out.print(" "+dp[i][j]);
//		}
//	System.out.println();
//	}
	//updating the base case of first row
	for(int j=1; j<=remCap; j++)
		if(weights[0]<=remCap)
			dp[0][j]= values[0];
	// work on remaining table

	for(int i=1; i<n; i++)
		for(int j=1; j<=remCap; j++) {
			int maxProfit1=0;
			int maxProfit2=0;
			if(weights[i]<=j)
				maxProfit1= values[i]+dp[i-1][remCap-weights[i]];
			maxProfit2= dp[i-1][remCap];
			dp[i][j]=Math.max(maxProfit1, maxProfit2);
		}
	// Items taken
	int totalMaxProfit= dp[n-1][remCap];
	for(int i=n-1; i>0;i--) {
		if(totalMaxProfit!=dp[i-1][remCap])
		{
			takenItems.add(i);
			remCap-=weights[i];
			totalMaxProfit-=values[i];
		}
	}
	if(totalMaxProfit!=0)
		takenItems.add(0);
	
	return dp[n-1][remCap];
	
}
}
