//701. Insert into a Binary Search Tree
//https://leetcode.com/problems/insert-into-a-binary-search-tree/
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

//Intution: if the value to be entered is <= root value travel left else travel right
//once a null is hit, thats the place where the value to be inserted destined to be

//TC: O(N)  SC:O(1)
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
            return new TreeNode(val);
        TreeNode currNode=root;
        while(true){
            if(val<=currNode.val){
                if(currNode.left==null){
                    currNode.left=new TreeNode(val);
                    break;
                }
                else{
                    currNode=currNode.left;
                }
            }else{
                if(currNode.right==null){
                    currNode.right=new TreeNode(val);
                    break;
                }
                else{
                    currNode=currNode.right;
                }    
            }      
        }
        return root;
    }
}
