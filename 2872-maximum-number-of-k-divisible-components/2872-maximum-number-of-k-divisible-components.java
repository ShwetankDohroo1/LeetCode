class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        //i use dfs because its easy
        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0;i<n;i++){
            tree.add(new ArrayList<>());
        }
        for(int[] i:edges){
            tree.get(i[0]).add(i[1]);
            tree.get(i[1]).add(i[0]);
        }
        int[] count = new int[1];
        dfs(0, -1, tree, values, k, count);       
        return count[0];
    }
    
    private int dfs(int node, int parent, List<List<Integer>> tree, int[] values, int k, int[] count){
        int sum = values[node];
        for(int i:tree.get(node)){
            if(i != parent){
                sum += dfs(i, node, tree, values, k, count);
            }
        }
        if(sum % k == 0){
            count[0]++;
            return 0;
        }
        return sum % k;
    }
}
