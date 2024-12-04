class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) 
            return;
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O') 
                dfs(board, vis, i, 0);//left
            if(board[i][m - 1] == 'O') 
                dfs(board, vis, i, m - 1);//right
        }
        for(int j = 0; j < m; j++){
            if(board[0][j] == 'O') 
                dfs(board, vis, 0, j);//top
            if(board[n - 1][j] == 'O') 
                dfs(board, vis, n - 1, j);//bottom
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && !vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] board, boolean[][] vis, int x, int y) {
        int n = board.length;
        int m = board[0].length;   
        if(x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O' || vis[x][y]){
            return;
        }
        vis[x][y] = true;
        
        dfs(board, vis, x + 1, y);
        dfs(board, vis, x - 1, y);
        dfs(board, vis, x, y + 1);
        dfs(board, vis, x, y - 1);
    }
}
