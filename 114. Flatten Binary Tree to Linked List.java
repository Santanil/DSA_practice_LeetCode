//114. Flatten Binary Tree to Linked List
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
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

// //Recursive
// //TC:O(N)   SC:O(H) or O(N) for skew tree
class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) 
            return; 
        
        flatten(root.right); 
        flatten(root.left); 
        
        root.right = prev;
        root.left = null; 
        prev = root; 
    }
}

//Iterative
//TC:O(N)   SC:O(H) or O(N) for skew tree
class Solution {
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode cur=s.pop();
            if(cur.right!=null)
                s.push(cur.right);
            if(cur.left!=null)
                s.push(cur.left);
            if(!s.isEmpty())
                cur.right=s.peek();
            cur.left=null;
        }    
    }
}


//TC:O(N)  SC:O(1)
class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
		while (cur != null)
		{
			if(cur.left != null)
			{
				TreeNode pre = cur.left;
				while(pre.right != null)
				{
					pre = pre.right;
				}
				pre.right = cur.right;
				cur.right = cur.left;
				cur.left = null;
			}
			cur = cur.right;
		}
    }
}
