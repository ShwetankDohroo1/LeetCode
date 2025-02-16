class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) 
            return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<TreeNode> curr = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                curr.add(node);
                if(node.left != null) 
                    queue.add(node.left);
                if(node.right != null) 
                    queue.add(node.right);
            }
            if(level % 2 == 1){
                int left = 0, right = curr.size() - 1;
                while(left < right){
                    int temp = curr.get(left).val;
                    curr.get(left).val = curr.get(right).val;
                    curr.get(right).val = temp;
                    left++;
                    right--;
                }
            }
            level++;
        }
        return root;
    }
}
