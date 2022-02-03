//226. Invert Binary Tree
//https://leetcode.com/problems/invert-binary-tree/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0


//Intution: We are swaping the right and the left node for each node
//TC:O(N)  SC:O(H)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
//TC:O(N)  SC:O(H)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;
        TreeNode temp=root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(temp);
        return root;
    }
}
