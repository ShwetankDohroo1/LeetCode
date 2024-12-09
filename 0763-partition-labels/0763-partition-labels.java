class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        return checking(ans,s,str);
    }
    public List<Integer> checking(List<Integer> ans,String s, StringBuilder s1){
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for(int i=0;i<s.length();i++){
            end = Math.max(end, arr[s.charAt(i) - 'a']);
            if(i == end){
                ans.add(i - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}