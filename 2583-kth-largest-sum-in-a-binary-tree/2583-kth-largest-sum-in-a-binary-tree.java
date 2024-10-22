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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<Long> ans = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            long levelsum = 0;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                levelsum += node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            ans.add(levelsum);
        }
        Collections.sort(ans, Collections.reverseOrder());
        if(k > ans.size()) return -1;
        return ans.get(k - 1);
    }
}