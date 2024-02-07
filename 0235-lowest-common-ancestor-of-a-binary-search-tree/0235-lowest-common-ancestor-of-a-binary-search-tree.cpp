/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == nullptr){
            return nullptr;
        }

        if(p->val < root->val && q->val < root->val){
            TreeNode* leftans = lowestCommonAncestor(root->left,p,q);
            return leftans;
        }
        if(p->val > root->val && q->val > root->val){
            TreeNode* rightans = lowestCommonAncestor(root->right,p,q);
            return rightans;
        }
        if(p->val < root->val && q->val > root->val){
            return root;
        }
        if(p->val > root->val && q->val < root->val){
            return root;
        }
        return root;
    }
};