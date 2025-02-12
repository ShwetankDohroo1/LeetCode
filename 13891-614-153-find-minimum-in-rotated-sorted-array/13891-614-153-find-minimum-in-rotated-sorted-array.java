class Solution {
    public int findMin(int[] nums) {
        int s = 0,e = nums.length-1;
        while(s < e){
            int mid = (s+e)/2;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            else if(nums[mid] < nums[e]){
                e = mid;
            }
            else{
                s = mid+1;
            }
        }
        return nums[s];
    }
}