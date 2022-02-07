//236. Lowest Common Ancestor of a Binary Tree
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Intution: we will go depth first and will the node value if it matches p or q value else return null. In case for a node it gets 2 not null values that means that node is the LCA and we need to return that node value over to the caller
//TC:O(N) 
//SC:O(H) normally and O(N) for skew trees
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val || root.val==q.val)
            return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null)
            return right;
        else if(right==null)
            return left;
        else
            return root;
        
    }
}
