class Solution {
    public int change(int amount, int[] coins) {
        // int[] ans = new int[amount + 1];
        // ans[0]=1;
        // for(int c:coins){
        //     for(int i = c;i<=amount;i++){
        //         ans[i] += ans[i - c];
        //         System.out.print(ans[i] + " ");
        //     }
        // }
        // return ans[amount];
        int[][] dp = new int[amount+1][amount+1];
        for(int i=0;i<amount+1;i++){
            for(int j=0;j<amount+1;j++){
                dp[i][j] = -1;
            }
        }
        return help(coins,0,amount,dp);
    }
    int help(int[] coins, int i,int am,int[][] dp){
        if(am == 0){
            return 1;
        }
        if(coins.length == i || am < 0){
            return 0;
        }
        if(dp[i][am] != -1){
            return dp[i][am];
        }
        return dp[i][am] = help(coins,i,am-coins[i],dp) + help(coins,i+1,am,dp);
    }
}