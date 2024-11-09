class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i=0;i<n+1;i++){
            dp[i] = -1;
        }
        return help(n,dp);
    }
    public int help(int n,int[] dp){
        if(n == 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int i=1,res = Integer.MAX_VALUE;
        while(i*i <= n){
            res = Math.min(res,1+help(n-i*i,dp));
            i++;
        }
        return dp[n] = res;
    }
}