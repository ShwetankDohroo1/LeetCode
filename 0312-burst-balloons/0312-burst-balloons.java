class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length+2][nums.length+2];
        int[] dum = new int[nums.length+2];
        for(int i=0;i<nums.length;i++){
            dum[i+1] = nums[i];
        }
        dum[0] = dum[nums.length+1] = 1;
        for(int i=0;i<nums.length+2;i++){
            for(int j=0;j<nums.length+2;j++){
                dp[i][j] = -1;
            }
        }
        return help(nums,dum,dp,0,nums.length+1);
    }
    public int help(int[] nums,int[]dum, int[][] dp,int i,int j){
        if(i+1 == j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int sum = 0;
        for(int a = i+1;a<j;a++){
            int ans = dum[a] * dum[i] * dum[j] + help(nums,dum,dp,i,a) + help(nums,dum,dp,a,j);
            sum = Math.max(sum,ans);
        }
        return dp[i][j] = sum;
    }
}