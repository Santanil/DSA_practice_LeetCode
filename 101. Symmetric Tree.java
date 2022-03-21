//101. Symmetric Tree
//https://leetcode.com/problems/symmetric-tree/
//https://www.youtube.com/watch?v=nKggNAiEpBE&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=26


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
//Intution: In mirror image left appears on right. passing left and right node of the root to the checkSymmetric function.
//In checkSymmetric function moving left of left and right of right at the same time to compare
//Again right of left and left of right at the same time

//TC:O(N)
//SC:O(H)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root==null || checkSymmetric(root.left,root.right);    
    }
    public static boolean checkSymmetric(TreeNode left,TreeNode right){
        if(left==null || right==null) //important step
            return left==right;
        if(left.val!=right.val)
            return false;
        return checkSymmetric(left.left,right.right) && checkSymmetric(left.right,right.left);
    }
}
