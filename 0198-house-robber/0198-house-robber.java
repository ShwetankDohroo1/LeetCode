class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        for(int i=0;i<nums.length+1;i++){
            dp[i] = -1;
        }
        return help(dp,nums,0);
    }
    public int help(int[] dp, int[] nums, int i){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int pick = nums[i] + help(dp,nums,i+2);
        int nopick = 0+help(dp,nums,i+1);
        dp[i] = Math.max(pick,nopick);
        return dp[i];
    }
}