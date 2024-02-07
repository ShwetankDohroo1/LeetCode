/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        if(preorder.empty()) 
            return nullptr;
        return constructBST(preorder, 0, preorder.size() - 1);
    }
    
private:
    TreeNode* constructBST(vector<int>& preorder, int start, int end) {
        if(start > end)
            return nullptr;
        TreeNode* root = new TreeNode(preorder[start]);

        int i;
        for(i=start+1;i<=end;i++){
            if(preorder[i] > preorder[start]) 
                break;
        }
        root->left = constructBST(preorder, start + 1, i - 1);
        root->right = constructBST(preorder, i, end);

        return root;
    }
};