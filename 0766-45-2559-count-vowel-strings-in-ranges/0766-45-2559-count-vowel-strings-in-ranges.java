class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        boolean[] check = new boolean[words.length];
        for(int i=0;i<words.length;i++){
            String a = words[i];
            char b = a.charAt(0);
            char c = a.charAt(a.length() - 1);
            if(isVowel(b) && isVowel(c)){
                check[i] = true;
            }
        }
        int[] pre = new int[words.length + 1];
        for(int i=0;i<words.length;i++){
            pre[i + 1] = pre[i] + (check[i]?1:0);
        }
        int[] ans = new int[queries.length];
        for(int z=0;z<queries.length;z++){
            int a = queries[z][0];
            int b = queries[z][1];
            ans[z] = pre[b + 1] - pre[a];
        }
        return ans;
    }
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
