class Solution {
public:
    string minWindow(string s, string t) {
        vector<int> ans(128,0);
        int a = t.size();
        for(char c:t){
            ans[c]++;
        }
        int left = 0;
        int right = 0;
        int minlen = INT_MAX;
        int start = 0;
        while(right < s.size()){
            if(ans[s[right++]]-- > 0){
                a--;
            }
            while(a == 0){
                if(right - left < minlen){
                    minlen = right - left;
                    start = left;
                }
                if(ans[s[left++]]++ == 0){
                    a++;
                }
            }
        }
        return minlen == INT_MAX?"": s.substr(start, minlen);
    }
};