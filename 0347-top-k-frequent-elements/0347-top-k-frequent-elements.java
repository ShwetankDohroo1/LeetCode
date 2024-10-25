class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i:nums){
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> mp.get(a) - mp.get(b));
        for(int i:mp.keySet()){
            pq.offer(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i] = pq.poll();
        }
        
        return ans;
    }
}