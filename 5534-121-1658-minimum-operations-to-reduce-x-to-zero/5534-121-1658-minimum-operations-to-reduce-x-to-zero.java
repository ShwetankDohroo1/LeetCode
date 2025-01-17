class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for(int i:nums){
            total += i;
        }
        int req = total - x;
        if(req < 0){
            return -1;
        }
        if(req == 0){
            return nums.length;
        }
        int maxi = 0;
        int sum = 0;
        int l=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            while(sum > req){
                sum -= nums[l];
                l++;
            }
            if(sum == req){
                maxi = Math.max(maxi, i - l +1);
            }
        }
        return maxi == 0 ? -1 : nums.length-maxi;
    }
}