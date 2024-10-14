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
    public boolean isValidBST(TreeNode root) {
        return checking(root, null, null);
    }
    public boolean checking(TreeNode root, TreeNode left, TreeNode right){
        if(root == null){
            return true;
        }
        else if((left!=null && root.val <= left.val) || (right!=null && root.val >= right.val)){
            return false;
        }
        return checking(root.left, left, root) && checking(root.right,root,right);
    }
}