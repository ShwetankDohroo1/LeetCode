class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] curr = new boolean[numCourses];
        boolean[] vis = new boolean[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] i : prerequisites){
            graph.get(i[1]).add(i[0]);
        }
        for(int i = 0; i < numCourses; i++){
            if(!vis[i] && hasCycle(i, graph, vis, curr)){
                return false;
            }
        }
        return true;
    }
    
    private boolean hasCycle(int course, List<List<Integer>> graph, boolean[] vis, boolean[] curr) {
        if(curr[course]) 
            return true;
        if(vis[course]) 
            return false;
        curr[course] = true;
        for(int neighbor : graph.get(course)){
            if(hasCycle(neighbor, graph, vis, curr)){
                return true;
            }
        }
        curr[course] = false;
        vis[course] = true;
        return false;
    }
}
