class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> mp = new HashMap<>();
        int ans = 0;
        int prefix = 0;
        mp.put(0,1);
        for(int i:nums){
            prefix += i;
            if(mp.containsKey(prefix - goal)){
                ans += mp.get(prefix - goal);
            }
            mp.put(prefix, mp.getOrDefault(prefix, 0) + 1);
        }
        return ans;
    }
}