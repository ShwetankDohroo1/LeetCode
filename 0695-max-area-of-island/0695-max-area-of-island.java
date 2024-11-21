class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){//start
                    int area = dfs(grid, i, j);
                    ans = Math.max(ans, area);
                }
            }
        }
        
        return ans;
    }
    public int dfs(int[][] grid,int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        
        int ans = 1;
        ans += dfs(grid, i + 1, j);//down
        ans += dfs(grid, i - 1, j);//up
        ans += dfs(grid, i, j + 1);//right
        ans += dfs(grid, i, j - 1);//left
        return ans;
    }
}