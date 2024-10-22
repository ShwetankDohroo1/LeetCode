class Solution {
    public void adding(String nums1, String nums2, int i, int j, int carry, StringBuilder ans){
        if(i < 0 && j < 0){
            if(carry != 0){
                ans.append(carry);
            }
            return;
        }
        
        int n1 = (i >= 0 ? nums1.charAt(i) : '0') -'0';
        int n2 = (j >= 0 ? nums2.charAt(j) : '0') -'0';
        int sum = n1 + n2 + carry;
        int digit = sum % 10;
        carry = sum/10;
        ans.append(digit);
        adding(nums1,nums2,i-1,j-1,carry,ans);
        
    }
    public String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        adding(num1,num2,num1.length()-1,num2.length() -1,0,ans);
        return ans.reverse().toString();
    }
}