class Solution {
public:
    bool isit(const string& token){
        return token == "+" || token == "-" || token == "*" || token == "/";
    }
    int evalRPN(vector<string>& tokens) {
        stack<int> ans;
        for(const string& c:tokens){
            if(isit(c)){
                int b = ans.top();
                ans.pop();
                int a = ans.top();
                ans.pop();
                int result;
                if(c == "+"){
                    result = a + b;
                } 
                else if(c == "-"){
                    result = a - b;
                } 
                else if(c == "*"){
                    result = a * b;
                } 
                else if(c == "/"){
                    result = a / b;
                }
                ans.push(result);
            } 
            else{
                ans.push(stoi(c));
            }
        }
        return ans.top();
    }
};