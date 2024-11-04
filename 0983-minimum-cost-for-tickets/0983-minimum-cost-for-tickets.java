class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Boolean[] dp1 = new Boolean[366];
        for(int day:days){
            dp1[day] = true; 
        }
        int[] dp = new int[366];
        dp[0] = 0;
        for(int i=1;i<=365;i++){
            if(dp1[i] == null || !dp1[i]){
                dp[i] = dp[i-1];
            }
            else{
                dp[i] = Math.min(dp[i - 1] + costs[0],
                        Math.min(dp[Math.max(0, i - 7)] + costs[1],
                        dp[Math.max(0, i - 30)] + costs[2]));
            }
        }
        return dp[365];
    }
}