import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minOperations(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int num : nums){
            st.add(num);
        }
        int[] arr = new int[st.size()];
        int index = 0;
        for(int num:st){
            arr[index++] = num;
        }
        Arrays.sort(arr);
        int n = nums.length;
        int ans = n;
        int j = 0;
        for(int i=0;i<arr.length;i++){
            while(j < arr.length && arr[j]-arr[i]<n){
                j++;
            }
            ans = Math.min(ans, n - (j - i));
        }
        return ans;
    }
}
