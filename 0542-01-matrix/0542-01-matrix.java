class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] distance = new int[n][m];
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    distance[i][j] = 0;
                    q.add(new int[]{i,j});
                }
                else{
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            for(int[] i:directions){
                int newX = x + i[0];
                int newY = y + i[1];
                if(newX >= 0 && newX < n && newY >= 0 && newY < m){
                    if(distance[newX][newY] > distance[x][y] + 1){
                        distance[newX][newY] = distance[x][y] + 1;
                        q.add(new int[]{newX, newY});
                    }
                }
            }
        }
        return distance;
    }
}