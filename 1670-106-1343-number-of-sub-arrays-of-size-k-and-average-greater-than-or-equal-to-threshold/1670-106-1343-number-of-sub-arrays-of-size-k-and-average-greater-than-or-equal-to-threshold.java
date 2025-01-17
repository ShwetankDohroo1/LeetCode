class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        } 
        int ans = 0;  
        int req = k*threshold;
        if(sum >= req){
            ans++;
        }
        for(int i=k;i<arr.length;i++){
            sum +=arr[i] - arr[i-k];
            if(sum >= req){
                ans++;
            }
        }
        return ans;
    }
}