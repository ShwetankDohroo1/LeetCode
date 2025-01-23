class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int ans = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    int count = dfs(i,j,vis,grid);
                    if(count > 1) { 
                        ans += count; 
                    }
                }
            }
        }
        return ans;
    }

    public int dfs(int i, int j, boolean[][] vis, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        vis[i][j] = true;
        for(int k = 0;k<n;k++){
            if(grid[i][k] == 1 && !vis[i][k]){
                count+= dfs(i,k,vis,grid);
            }
        }
        for(int k=0;k<m;k++){
            if(grid[k][j] == 1 && !vis[k][j]){
                count+=dfs(k,j,vis,grid);
            }
        }
        return count + 1;
    }
}