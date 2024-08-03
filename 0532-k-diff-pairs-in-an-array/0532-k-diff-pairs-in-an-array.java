class Solution {
    public int findPairs(int[] nums, int k) {
        if(k<0){
            return 0;
        }
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i:nums){
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            int num = entry.getKey();
            if(k == 0){
                if(entry.getValue() > 1){
                    count++;
                }
            } 
            else{
                if(mp.containsKey(num + k)){
                    count++;
                }
            }
        }
        return count;
    }
}