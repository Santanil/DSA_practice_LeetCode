//110. Balanced Binary Tree
//https://leetcode.com/problems/balanced-binary-tree/
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

//Intution: Similar to finding depth of binary tree, just if at any point of time if the absolute diffrence between the leftHeight and rightHeight>1 it will return a value of -1
//returning -1 indicated the binary tree is not balanced 
//additionally we are checking at any point of time if leftHeight=-1 or rightHeight=-1, then we are directly returning -1 to the calling function to avoid further doen traversals

//TC:O(N)   SC:O(H).....incase of skewed tree SC:O(N)
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(dfs(root)==-1)
            return false;
        else
            return true;
    }
    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        int leftHeight=dfs(root.left);
        int rightHeight=dfs(root.right);
        if(leftHeight==-1 || rightHeight==-1)
            return -1;
        
        if(Math.abs(leftHeight-rightHeight)>1)
            return -1;
        
        return Math.max(leftHeight,rightHeight)+1;
    }
}

