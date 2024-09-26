class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> st = new HashSet<>();
        for(String i:emails){
            String[] str = i.split("@");
            String first = str[0];
            String second = str[1];
            first = first.replace(".","").split("\\+")[0];
            String ans = first + "@" + second;
            st.add(ans);
        }
        return st.size();
    }
}