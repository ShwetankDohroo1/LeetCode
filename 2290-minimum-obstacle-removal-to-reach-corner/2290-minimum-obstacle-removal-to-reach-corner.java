class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //directions for moving up, down, left, right
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        //priority queue to process cells by minimum obstacles removed
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0}); //row, col, obstacles removed

        //visited array to track minimum obstacles removed to reach a cell
        int[][] vis = new int[m][n];
        for(int[] i:vis){
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        //marking starting point visited
        vis[0][0] = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int x = curr[0], y = curr[1], obstacles = curr[2];
            //if we reach the bottom-right corner return
            if(x == m - 1 && y == n - 1){
                return obstacles;
            }
            //go to all 4 possible directions
            for(int[] i:dir){
                int nx = x + i[0];
                int ny = y + i[1];
                //check for bounds
                if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                    int newOB = obstacles + grid[nx][ny];
                    //if this path removes fewer obstacles, update and explore
                    if(newOB < vis[nx][ny]){
                        vis[nx][ny] = newOB;
                        pq.offer(new int[]{nx, ny, newOB});
                    }
                }
            }
        }
        return -1;
    }
}