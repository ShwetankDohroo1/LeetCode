class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            //we compare by the improvement ratio, which is:
            //(pass+1)/(total+1) - pass/total
            double improvementA = ((double)(a[0] + 1) / (a[1] + 1)) - ((double)a[0] / a[1]);
            double improvementB = ((double)(b[0] + 1) / (b[1] + 1)) - ((double)b[0] / b[1]);
            return Double.compare(improvementB, improvementA); //max-heap
        });
        for(int[] i:classes){
            pq.offer(i);
        }
        for(int i=0;i<extraStudents;i++){
            int[] maxi = pq.poll();
            maxi[0] += 1;
            maxi[1] += 1;
            pq.offer(maxi);
        }
        double totalPassRatio = 0;
        for(int[] i:classes){
            totalPassRatio += (double)i[0] / i[1];
        }
        return totalPassRatio / classes.length;
    }
}
