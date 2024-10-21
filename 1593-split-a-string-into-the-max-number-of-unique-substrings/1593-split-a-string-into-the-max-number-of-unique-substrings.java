class Solution {
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        return helper(s, 0, set);
    }
    public int helper(String s, int p, Set<String> set) {
        if(p == s.length()){
            return 0;
        }
        int ans = 0;
        for(int i = p+1;i<=s.length();i++){
            String substring = s.substring(p, i);
            if(!set.contains(substring)){
                set.add(substring);
                int result = 1 + helper(s, i, set);
                ans = Math.max(ans, result);
                set.remove(substring);
            }
        }
        return ans;
    }
}
