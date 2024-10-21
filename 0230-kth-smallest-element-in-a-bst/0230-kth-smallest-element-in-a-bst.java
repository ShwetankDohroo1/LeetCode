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
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;//counter for the number of nodes visited
        TreeNode curr = root;//start from the root
        while(curr != null){
            if(curr.left == null){
                //visit the current node
                count++;
                if(count == k){
                    return curr.val;//if it's the kth smallest, return its value
                }
                curr = curr.right;//move to the right child
            } 
            else{
                //find the rightmost node in the left subtree
                TreeNode p = curr.left;
                while(p.right != null && p.right != curr){
                    p = p.right;
                }
                //make the current node the right child of its predecessor
                if(p.right == null){
                    p.right = curr;//create a temporary link
                    curr = curr.left;//move to the left child
                } 
                else{
                    //revert the changes made to restore the original tree
                    p.right = null;//remove the temporary link
                    count++;//visit the current node
                    if(count == k){
                        return curr.val;//if it's the kth smallest, return its value
                    }
                    curr = curr.right;//move to the right child
                }
            }
        }

        return -1;
    }
}
