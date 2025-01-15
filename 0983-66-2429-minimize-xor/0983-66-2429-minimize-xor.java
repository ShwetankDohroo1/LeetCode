class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBit = Integer.bitCount(num2);
        int ans = 0;
        for(int i = 31;i >= 0 && setBit  > 0;i--){
            if((num1 & (1 << i)) != 0){
                ans |= (1<<i);
                setBit--;
            }
        }
        for(int i=0;i<= 31 && setBit > 0;i++){
            if((ans & (1<< i)) == 0){
                ans |= (1<<i);
                setBit--;
            }
        }
        return ans;
    }
}