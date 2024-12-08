class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return checking(s, p, 0, 0, memo);
    }
    
    private boolean checking(String s, String p, int i, int j, Boolean[][] memo) {
        //base case
        if(i == s.length() && j == p.length()){
            return true;
        }
        //if pattern is finished still no match
        if(j == p.length()){
            return false;
        }
        //check if already exists
        if(memo[i][j] != null){
            return memo[i][j];
        }
        boolean match = false;
        //case 1: If the current characters match, or the pattern has a '.' 
        if(i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')){
            match = checking(s, p, i + 1, j + 1, memo);
        }
        //case 2: If the pattern character is '*', it can either match zero or more of the previous character
        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            //skip '*'
            match = match || checking(s, p, i, j + 2, memo);
            if(i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')){
                match = match || checking(s, p, i + 1, j, memo);
            }
        }
        //remember in memo
        memo[i][j] = match;
        return match;
    }
}
