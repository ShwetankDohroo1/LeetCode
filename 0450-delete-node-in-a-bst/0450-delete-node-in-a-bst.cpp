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
    TreeNode* maxVal(TreeNode* root){
        if(root == nullptr){
            return nullptr;
        }
        TreeNode* temp = root;
        while(temp->right != NULL){
            temp = temp->right;
        }
        return temp;
    }
    TreeNode* deleteNode(TreeNode* root, int target) {
        if(root == nullptr){
            return nullptr;
        }
        if(root->val == target){
            //we have 4 cases now
            if(root->left == NULL && root->right == NULL){
                delete root;
                return NULL;
            }
            else if(root->left != NULL && root->right ==  NULL){
                TreeNode* temp = root->left;
                delete root;
                return temp;
            }
            else if(root->left == NULL && root->right != NULL){
                TreeNode* temp = root->right;
                delete root;
                return temp;
            }
            else{
                TreeNode* maxi = maxVal(root->left);
                root->val = maxi->val;
                root->left = deleteNode(root->left,maxi->val);
                return root;
            }
        }
        else if(root->val > target){
            root->left = deleteNode(root->left,target);
        }
        else{
            root->right = deleteNode(root->right,target);
        }
        return root;
    }
};