class Solution {
    public void finding(List<List<Integer>> list1, List<Integer> list2,int[]nums, int i){
        if(i == nums.length){
            list1.add(new ArrayList<>(list2));
            return;
        }
        for(int j=i;j<nums.length;j++){
            swap(i,j,list2);
            finding(list1,list2,nums,i+1);
            swap(i,j,list2);
        }
    }
    public void swap(int a,int b,List<Integer> n){
        int temp = n.get(a);
        n.set(a,n.get(b));
        n.set(b,temp);
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list =  new ArrayList<>();
        for(int i:nums){
            list.add(i);
        }
        finding(ans,list,nums,0);
        return ans;
    }
}