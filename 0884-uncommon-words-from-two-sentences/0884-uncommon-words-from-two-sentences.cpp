class Solution {
public:
    vector<string> uncommonFromSentences(string s1, string s2) {
        map<string, int> mp;
        vector<string> result;
        auto count =[&](string s){
            istringstream iss(s);
            string word;
            while(iss >> word){
                mp[word]++;
            }
        };
        count(s1);
        count(s2);
        for(auto entry : mp){
            if(entry.second == 1){
                result.push_back(entry.first);
            }
        }
        return result;
    }
};