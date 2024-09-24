class Solution {
    public String compare(String a, String b){
        return (a + b).compareTo(b + a) > 0 ? a : b;
    }
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });
        if(str[0].equals("0")){
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for(String s:str){
            ans.append(s);
        }
        return ans.toString();
    }
}