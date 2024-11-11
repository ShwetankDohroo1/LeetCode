class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++){
            for(int j=0;j<word2.length();j++){
                dp[i][j] = -1;
            }
        }
        return help(word1,word2,dp,0,0);
    }
    public int help(String word1, String word2, int[][] dp, int i, int j){
        if(i == word1.length()){
            return word2.length() - j;
        }
        if(j == word2.length()){
            return word1.length() -i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = help(word1,word2,dp,i+1,j+1);
        }
        else{
            int a = 1+ help(word1,word2,dp,i,j+1);
            int b = 1+ help(word1,word2,dp,i+1,j);
            int c = 1+ help(word1,word2,dp,i+1,j+1);
            dp[i][j] = Math.min(a, Math.min(b,c));
        }
        return dp[i][j];
    }
}