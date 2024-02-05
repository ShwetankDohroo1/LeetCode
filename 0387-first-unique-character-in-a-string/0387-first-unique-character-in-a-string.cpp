class Solution {
public:
    int firstUniqChar(string s) {
        for(int i=0;i<s.size();i++){
            int count = 0;
            for(int j=0;j<s.size();j++){
                if(i!=j && s[i] == s[j]){
                    count++;
                    break;
                }
            }
            if(count == 0){
                return i;
            }
        }
        return -1;
    }
};