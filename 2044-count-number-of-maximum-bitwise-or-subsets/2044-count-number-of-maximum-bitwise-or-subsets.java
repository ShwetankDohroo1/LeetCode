class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int i:nums){
            maxOr |= i;
        }
        return count(nums, maxOr, 0, 0);
    }
    
    private int count(int[] nums, int maxOr, int index, int currentOr) {
        if(index == nums.length){
            return currentOr == maxOr ? 1 : 0;
        }
        int include = count(nums, maxOr, index + 1, currentOr | nums[index]);
        int exclude = count(nums, maxOr, index + 1, currentOr);
        return include + exclude;
    }
}
