class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for(String i:strs){
            char[] chstr = i.toCharArray();
            Arrays.sort(chstr);
            String sortedStr = new String(chstr);
            if(!mp.containsKey(sortedStr)){
                mp.put(sortedStr, new ArrayList<>());
            }
            mp.get(sortedStr).add(i);
        }
        return new ArrayList<>(mp.values());
    }
}