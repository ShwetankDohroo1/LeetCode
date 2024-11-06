class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i=0;i<amount+1;i++){
            dp[i] = -1;
        }
        int ans = help(coins,amount,dp);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
    public int help(int[] coins, int a, int[] dp){
        if(a == 0){
            return 0;
        }
        if(dp[a] != -1){
            return dp[a];
        }
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(a - coins[i] >= 0){
                int ans = help(coins,a-coins[i],dp);
                if(ans != Integer.MAX_VALUE){
                    int ans1 = 1+ans;
                    mini = Math.min(mini,ans1);
                }
            }
        }
        dp[a] = mini;
        return dp[a];
    }
}