class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int[] arr = new int[2];
        
        if(nums.length == 0){
            arr[0] = start;
            arr[1] = end;
            return arr;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                start = i;
                break;
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i] == target){
                end = i;
                break;
            }
        }
        
        arr[0] = start;
        arr[1] = end;
        return arr;
    }
}
