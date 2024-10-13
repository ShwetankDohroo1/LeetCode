class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        int maxi = Integer.MIN_VALUE;
        int s = 0;
        int e = Integer.MAX_VALUE;
        for(int i=0;i<nums.size();i++){
            int val = nums.get(i).get(0);
            heap.offer(new int[]{val, i, 0});
            maxi = Math.max(maxi, val);
        }
        while(heap.size() == nums.size()){
            int[] curr = heap.poll();
            int min = curr[0];
            int indx1 = curr[1];
            int indx2 = curr[2];
            if(maxi - min < e - s){
                s = min;
                e = maxi;
            }
            if(indx2 + 1 < nums.get(indx1).size()){
                int nextVal = nums.get(indx1).get(indx2 + 1);
                heap.offer(new int[]{nextVal, indx1, indx2 + 1});
                maxi = Math.max(maxi, nextVal);
            }
        }

        return new int[]{s, e};
    }
}