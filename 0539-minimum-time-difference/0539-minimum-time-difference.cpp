class Solution {
public:
    int findMinDifference(vector<string>& timePoints) {
        vector<int> vect;
        for(int i=0;i<timePoints.size();i++){
            vect.push_back(convert(timePoints[i]));
        }
        int sathdiff = INT_MAX;
        sort(vect.begin(),vect.end());
        for(int i=1;i<vect.size();i++){
            sathdiff = min(sathdiff, (vect[i] - vect[i-1]));
        }
        int diff = (1440 - vect.back() + vect.front());
        sathdiff = min(sathdiff, diff);
        return sathdiff;
    }
    int convert(string& time){
        int hr = stoi(time.substr(0,2));
        int min = stoi(time.substr(3,2));
        return hr*60 + min;
    }
};