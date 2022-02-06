//112. Path Sum
//https://leetcode.com/problems/path-sum/
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
//Intution: will travel though every path and for each travel we will be decreasing the targetSUm by the value for that node and now upon reaching the leaf node if the targetSum==0 then it will return true else false
//TC:O(N)   SC:O(H)
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        targetSum-=root.val;
        if(root.left==null && root.right==null)
            return (targetSum==0);
        return hasPathSum(root.left,targetSum) || hasPathSum(root.right,targetSum);
    }
}
