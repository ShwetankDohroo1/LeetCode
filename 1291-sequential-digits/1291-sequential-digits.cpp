class Solution {
public:
    vector<int> sequentialDigits(int low, int high) {
        vector<int> ans;
        int num[] = {1,2,3,4,5,6,7,8,9};
        for(int i=0;i<9;i++){
            int a = 0;
            for(int j=i;j<9;j++){
                a = a * 10 + num[j];
                if(a >= low && a <= high){
                    ans.push_back(a);
                }
                if(a> high) 
                break;
            }
        }
        sort(ans.begin(),ans.end());
        return ans;
    }
};