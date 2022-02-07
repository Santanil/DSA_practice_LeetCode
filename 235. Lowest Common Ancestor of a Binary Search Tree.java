//235. Lowest Common Ancestor of a Binary Search Tree
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
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
//Intution: Since BST is sorted in inorder, therefore the node where the paths for both the node will move apart is the required node
//TC:O(H) since one of the subtree is discarded on every move and atmost we need to travel the height of the tree
//SC: O(1) since we are not storing any data
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur=root;
        while(cur!=null){
            if(p.val>cur.val && q.val>cur.val)
                cur=cur.right;
            else if(p.val<cur.val && q.val<cur.val)
                cur=cur.left;
            else 
                return cur;
        }
        return root;
    }
}
