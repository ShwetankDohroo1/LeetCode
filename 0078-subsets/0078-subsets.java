class Solution {
    public void krdu(List<List<Integer>> list1, List<Integer> list2, int[] nums, int i){
        if(i == nums.length){
            list1.add(new ArrayList<>(list2));
            return;
        }
        krdu(list1,list2,nums,i+1);
        list2.add(nums[i]);
        krdu(list1,list2,nums,i+1);
        list2.remove(list2.size() - 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        krdu(list, list1, nums,0);
        return list;
    }
}