class Solution {
    public void making(int[] candidates, int t, List<List<Integer>> ans, List<Integer> list, int i){
        if(t == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(t < 0){
            return;
        }
        for(int j=i;j<candidates.length;j++){
            list.add(candidates[j]);
            making(candidates,t-candidates[j],ans,list,j);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        making(candidates, target, ans, list, 0);
        return ans;
    }
}