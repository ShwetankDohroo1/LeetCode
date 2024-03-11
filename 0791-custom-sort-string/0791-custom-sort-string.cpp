class Solution {
public:
    string customSortString(string order, string s) {
        string ans = "";
        for(int i=0;i<order.size();i++){
            for(int j=0;j<s.size();j++){
                if(order[i] == s[j]){
                    ans.push_back(s[j]);
                }
            }
        }
        for(int j=0;j<s.size();j++){
            if(order.find(s[j]) == string::npos){
                ans.push_back(s[j]);
            }
        }
        return ans;
    }
};