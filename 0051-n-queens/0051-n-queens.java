import java.util.*;

class Solution {
    public void help(List<List<String>> ans, char[][] board, int col, int n) {

        if(col == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (checking(board, i, col, n)) {
                board[i][col] = 'Q';//place a queen
                help(ans, board, col + 1, n);//recurse for next column
                board[i][col] = '.'; //backtrack and remove the queen
            }
        }
    }
    public boolean checking(char[][] board, int row, int col, int n) {
        //check the upper-left diagonal
        int col1 = col;
        int row1 = row;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        //reset row and col
        col = col1;
        row = row1;

        //check the left side (same row)
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }
        col = col1;
        row = row1;

        //check the lower-left diagonal
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        //create an n x n board and initialize it with '.'
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        //start the recursive helper function from column 0
        help(ans, board, 0, n);
        return ans;
    }
}
