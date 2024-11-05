class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        return help(n,dp);
    }
    public int help(int n,int[] dp){
        if(n == 0 || n == 1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = help(n-1,dp) + help(n-2,dp);
        return dp[n];
    }
}