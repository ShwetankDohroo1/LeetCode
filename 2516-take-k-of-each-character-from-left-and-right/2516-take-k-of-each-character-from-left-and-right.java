class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int[] count = new int[3];
        for(char ch:s.toCharArray()){
            count[ch - 'a']++;
        }
        for(int i=0;i<3;i++){
            if(count[i] < k){
                return -1;
            }
        }
        int[] curr = new int[3];
        int maxi = 0;
        int left = 0;
        for(int right=0;right<n;right++){
            curr[s.charAt(right) - 'a']++;
            while(curr[0] > count[0] - k || curr[1] > count[1] - k || curr[2] > count[2] - k){
                curr[s.charAt(left) - 'a']--;
                left++;
            }
            maxi = Math.max(maxi, right - left + 1);
        }
        return n - maxi;
    }
}
