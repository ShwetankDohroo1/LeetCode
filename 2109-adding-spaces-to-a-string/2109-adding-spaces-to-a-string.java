class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length();
        int m = spaces.length;
        char[] ans = new char[n+m];
        int j = 0;
        int k = 0;
        for(int i=0;i<ans.length;i++){
            if(j < m && k == spaces[j]){
                ans[i] = ' ';
                j++;
            } 
            else{
                ans[i] = s.charAt(k);
                k++;
            }
        }
        return new String(ans);
    }
}