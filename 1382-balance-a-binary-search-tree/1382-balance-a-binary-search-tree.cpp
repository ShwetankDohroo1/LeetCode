class Solution {
public:
    void inorder(TreeNode* root, vector<int>& nodes) {
        if(!root)
            return;
        inorder(root->left, nodes);
        nodes.push_back(root->val);
        inorder(root->right, nodes);
    }
    
    TreeNode* constructBalancedBST(vector<int>& nodes, int start, int end) {
        if(start > end)
            return nullptr;
        
        int mid = start+(end - start)/2;
        TreeNode* newNode = new TreeNode(nodes[mid]);
        
        newNode->left = constructBalancedBST(nodes, start, mid - 1);
        newNode->right = constructBalancedBST(nodes, mid + 1, end);
        
        return newNode;
    }
    
    TreeNode* balanceBST(TreeNode* root) {
        vector<int> nodes;
        inorder(root, nodes);
        return constructBalancedBST(nodes, 0, nodes.size() - 1);
    }
};
