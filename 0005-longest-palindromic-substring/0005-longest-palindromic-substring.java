class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        int st = 0,e = 0;
        for(int i=0;i<s.length();i++){
            int len1 = checking(s,i,i);
            int len2 = checking(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len > e-st){
                st = i - (len-1) / 2;
                e = i + len / 2;
            }
        }
        return s.substring(st,e+1);
    }
    public int checking(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}