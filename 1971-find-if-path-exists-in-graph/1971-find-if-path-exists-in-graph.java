class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i =0;i<n;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Set<Integer> st = new HashSet<>();
        return dfs(source,destination,graph,st);
    }
    public boolean dfs(int s, int d, Map<Integer, List<Integer>> graph, Set<Integer> st){
        if(s == d){
            return true;
        }
        st.add(s);
        for(int i:graph.getOrDefault(s,new ArrayList<>())){
            if(!st.contains(i)){
                if(dfs(i,d,graph,st)){
                    return true;
                }
            }
        }
        return false;
    }
}