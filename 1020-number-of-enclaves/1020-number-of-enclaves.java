class Solution {
    public int numEnclaves(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            if(grid[i][0] == 1){
                dfs(vis,grid,i,0);
            }
            if(grid[i][m-1] == 1){
                dfs(vis,grid,i,m-1);
            }
        }
        for(int i=0;i<m;i++){
            if(grid[0][i] == 1){
                dfs(vis,grid,0,i);
            }
            if(grid[n-1][i] == 1){
                dfs(vis,grid,n-1,i);
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(boolean[][] vis, int[][] grid, int i, int j){
        int n = grid.length;
        int m = grid[0].length;
        if(i<0 || i >= n || j < 0 || j >= m || grid[i][j] != 1 || vis[i][j]){
            return;
        }
        vis[i][j] = true;
        
        dfs(vis,grid,i+1,j);
        dfs(vis,grid,i-1,j);
        dfs(vis,grid,i,j+1);
        dfs(vis,grid,i,j-1);
    }
}