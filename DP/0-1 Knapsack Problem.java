//GFG Practice

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n) 
    { 
         // your code here 
        int dp[][] = new int[n+1][w+1];
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=w;j++) {
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                
                else if(wt[i-1]<=j){
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
                
                else{
                    dp[i][j] = dp[i-1][j];
                } 
            }
        }
        return dp[n][w];
    } 
}
