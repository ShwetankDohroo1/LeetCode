class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    count++;
                    dfs(i, j, vis, grid);
                }
            }
        }
        return count;
    }
    public void dfs(int x, int y, boolean[][] vis, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        
        if (x < 0 || x >= n || y < 0 || y >= m || vis[x][y] || grid[x][y] == '0') {
            return;
        }
        
        vis[x][y] = true;
        
        
        dfs(x + 1, y, vis, grid);
        dfs(x - 1, y, vis, grid);
        dfs(x, y + 1, vis, grid);
        dfs(x, y - 1, vis, grid);
    }
}