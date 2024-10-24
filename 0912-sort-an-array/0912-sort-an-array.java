class Solution {
    public void mergeSort(int[] temp, int[] nums, int s, int e){
        if(s >= e){
            return;
        }
        int mid = (s+e) >> 1;
        mergeSort(temp,nums,s,mid);
        mergeSort(temp,nums,mid+1,e);
        merge(temp,nums,mid,s,e);
    }
    public void merge(int[] temp, int[] nums, int mid, int s, int e){
        int i = s, j = mid+1, k = s;
        while(i <= mid && j <= e){
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }
            else{
                temp[k++] = nums[j++];
            }
        }
        while(i <= mid) temp[k++] = nums[i++];
        while(k <= e) temp[k++] = nums[j++];
        while(s <= e){
            nums[s] = temp[s];
            s++;
        }
    }
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(temp, nums, 0 ,nums.length-1);
        return nums;
    }
}