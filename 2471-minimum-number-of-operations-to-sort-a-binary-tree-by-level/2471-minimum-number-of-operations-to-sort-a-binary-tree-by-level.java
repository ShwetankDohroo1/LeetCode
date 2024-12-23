/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
        if(root == null){return 0;}
        int count = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                l.add(node.val);
                if(node.left != null) 
                    q.offer(node.left);
                if(node.right != null) 
                    q.offer(node.right);
            }
            count+=checking(l);
        }
        return count;
    }
    public int checking(List<Integer> list){
        int n = list.size();
        int[] arr = new int[n];
        int[][] arr1 = new int[n][2];
        for(int i=0;i<n;i++){
            arr1[i][0] = list.get(i);
            arr1[i][1] = i;
        }
        Arrays.sort(arr1, (a, b) -> Integer.compare(a[0], b[0]));
        boolean[] vis = new boolean[n];
        int swaps = 0;
        for(int i=0;i<n;i++){
            if(vis[i] || arr1[i][1] == i) 
                continue;
            int s = 0;
            int j = i;
            while(!vis[j]){
                vis[j] = true;
                j = arr1[j][1];
                s++;
            }
            if(s > 1) 
                swaps += s - 1;
        }
        return swaps;
    }
}
