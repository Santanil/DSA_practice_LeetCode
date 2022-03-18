//124. Binary Tree Maximum Path Sum
//https://leetcode.com/problems/binary-tree-maximum-path-sum/
//https://www.youtube.com/watch?v=WszrfSwMz58&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=18

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

//TC: O(N)
//SC: O(N)
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] res=new int[1];
        //this is set for the corner case where maxPathSum is negative
        res[0]=Integer.MIN_VALUE;
        findMaxPathSum(root,res);
        return res[0];
    }
    public int findMaxPathSum(TreeNode node,int[] res){
        if(node==null)
            return 0;
        int left=Math.max(0,findMaxPathSum(node.left,res));
        int right=Math.max(0,findMaxPathSum(node.right,res));
        
        res[0]=Math.max(res[0],node.val+left+right);
        
        return node.val+Math.max(left,right);
    }
}
