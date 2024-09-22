class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while(k > 0){
            int count = getCount(n, curr, curr + 1);

            if(k >= count){
                k -= count;
                curr++;
            } 
            else{
                curr *= 10;
                k--;
            }
        }

        return curr;
    }
    int getCount(int n, long curr, long next) {
        int count = 0;
        while(curr <= n){
            count += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return count;
    }
}