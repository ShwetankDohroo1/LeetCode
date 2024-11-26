class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];
        
        // Step 1: Calculate in-degree for each node
        for (int[] edge : edges) {
            int v = edge[1];
            inDegree[v]++;
        }
        
        // Step 2: Find nodes with in-degree 0
        int champion = -1;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                // If there is already a candidate, no unique champion
                if (champion != -1) {
                    return -1;
                }
                champion = i;
            }
        }
        
        // Step 3: Return the unique champion or -1 if none found
        return champion;
    }
}
