//543. Diameter of Binary Tree
//https://leetcode.com/problems/diameter-of-binary-tree/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0

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

//TC:O(N)    SC;O(H)
class Solution {
    int diameter=0;
    public int height(TreeNode root){
        if(root==null)
            return -1;
        int hl=height(root.left);
        int hr=height(root.right);
        diameter=Math.max(diameter, hl+hr+2);
        return Math.max(hl,hr)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
}
