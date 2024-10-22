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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = true;
        int prev = 0;
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr != null){
                if(flag && !(curr.val % 2 != 0 && curr.val > prev)){
                    return false;
                }
                else if(!flag && !(curr.val % 2 == 0 && curr.val < prev)){
                    return false;
                }
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
                prev = curr.val;
            }
            else{
                prev  = flag ? Integer.MAX_VALUE : 0;
                flag = !flag;
                if(!q.isEmpty()){
                    q.offer(null);
                }
            }
        }
        return true;
    }
}