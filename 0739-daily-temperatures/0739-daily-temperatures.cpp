class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& arr) {
        vector<int> ans(arr.size(), 0);
        stack<int>st;
        for(int i=0;i<arr.size();i++){
            while(!st.empty() && arr[i] > arr[st.top()]){
                int a = st.top();
                st.pop();
                ans[a] = i - a;
            }
            st.push(i);
        }
        return ans;
    }
};