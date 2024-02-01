class Solution {
public:
    vector<vector<int>> divideArray(vector<int>& nums, int k) {
        vector<vector<int>>ans;
        if(nums.size()%3!=0)
            return {};
        sort(nums.begin(),nums.end());
        for(int i=0;i<nums.size();i+=3){
            if(nums[i+2]-nums[i]>k)
                return{};
            ans.push_back({nums[i],nums[i+1],nums[i+2]});
        }
        return ans;
    }
};