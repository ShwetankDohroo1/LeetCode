class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if (a > 0) pq.add(new int[] { 'a', a });
        if (b > 0) pq.add(new int[] { 'b', b });
        if (c > 0) pq.add(new int[] { 'c', c });
        
        StringBuilder ans = new StringBuilder();
        
        while(!pq.isEmpty()){
            int[] first = pq.poll();
            if(ans.length() >= 2 && ans.charAt(ans.length() - 1) == first[0] && ans.charAt(ans.length() - 2) == first[0]){
                if(pq.isEmpty()){
                    break;
                }
                int[] second = pq.poll();
                ans.append((char) second[0]);
                second[1]--;
                if(second[1] > 0){
                    pq.add(second);
                }
                pq.add(first);
            }
            else{
                ans.append((char) first[0]);
                first[1]--;
                if (first[1] > 0) {
                    pq.add(first);
                }
            }
        }
        
        return ans.toString();
    }
}
