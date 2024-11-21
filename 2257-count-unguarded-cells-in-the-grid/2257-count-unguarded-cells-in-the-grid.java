class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] map = new int[m][n];
        for(int[] i:walls){
            map[i[0]][i[1]] = 1;
        }
        for(int[] i:guards){
            map[i[0]][i[1]] = -1;
        }
        for(int[] g:guards){
            int a = g[0];
            int b = g[1];
            //up
            for(int j=a-1;j>=0 && map[j][b] != 1 && map[j][b] != -1;j--){
                map[j][b] = 2;
            }
            //down
            for(int i=a+1;i<m && map[i][b] != 1 && map[i][b] != -1;i++){
                map[i][b] = 2;
            }
            //right
            for(int i=b+1;i<n && map[a][i] != 1 && map[a][i]!=-1;i++){
                map[a][i] = 2;
            }
            //left
            for(int i=b-1;i>=0 && map[a][i] != 1 && map[a][i] != -1;i--){
                map[a][i] = 2;
            }
        }
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }
}