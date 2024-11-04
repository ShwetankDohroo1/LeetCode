class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = new HashSet<>();
        for(int i:days){
            set.add(i);
        }
        int ans = days[days.length -1];
        int[] dp = new int[ans + 1];
        dp[0] = 0;
        for(int i=1;i<=ans;i++){
            if(!set.contains(i)){
                dp[i] = dp[i-1];
            }
            else{
                int day1 = dp[i-1] + costs[0];
                int day7 = dp[Math.max(0,i-7)] + costs[1];
                int day30 = dp[Math.max(0,i-30)]  +costs[2];
                dp[i] = Math.min(day1,Math.min(day7,day30));
            }
        }
        return dp[ans];
    }
}