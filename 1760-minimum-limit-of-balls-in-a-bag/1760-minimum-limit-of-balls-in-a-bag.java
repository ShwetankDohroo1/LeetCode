class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 0;
        for(int i : nums){
            right = Math.max(right, i);
        }
        while(left < right) {
            int mid = left + (right - left) / 2;
            int operations = 0;
            for(int i : nums){
                if(i > mid){
                    operations += (i - 1) / mid;
                }
            }
            if(operations > maxOperations){
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
}
