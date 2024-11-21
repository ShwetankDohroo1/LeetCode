class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int og = image[sr][sc];
        if(og == color){
            return image;
        }
        dfs(image, sr, sc, color, og);
        return image;
    }
    public void dfs(int[][] image, int i, int j,int color, int og){
        if(i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != og){
            return;
        }
        image[i][j] = color;
        dfs(image,i-1,j,color,og);
        dfs(image,i+1,j,color,og);
        dfs(image,i,j-1,color,og);
        dfs(image,i,j+1,color,og);
    }
}