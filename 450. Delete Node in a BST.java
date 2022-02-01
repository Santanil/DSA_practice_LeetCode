//450. Delete Node in a BST
//https://leetcode.com/problems/delete-node-in-a-bst/
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
// class Solution {
//     public int findLargest(TreeNode root){
//         TreeNode pre=root,cur=root.left;
//         int data=cur.val;
//         while(cur.right!=null){
//             pre=cur;
//             cur=cur.right;
//             data=cur.val;
//         }
//         pre.right=null;
//         return data;
//     }
//     public TreeNode deleteNode(TreeNode root, int key) {
//         if(root==null)
//             return root;
//         TreeNode cur=root,pre=root;
//         if(root.val==key){
//             if(root.left==null && root.right==null)
//                 return;
//             else if(root.left==null && root.right!=null){
                
//             }
//         }
           
//         while(cur!=null){
//             if(cur.val==key){
//                 if(cur.left!=null && cur.right!=null){
//                     cur.val=findLargest(cur);
//                     System.out.print(cur.val);
//                     return root;
//                 }else if(cur.left!=null && cur.right==null){
//                     cur=cur.left;
//                     return root;
//                 }else{
//                     cur=cur.right;
//                     return root;
//                 }
//             }else if(cur.val>key){
//                 pre=cur;
//                 cur=cur.left;
//             }else{
//                 pre=cur;
//                 cur=cur.right;
//             }
//         }
//         return root;
//     }
// }
  
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return helper(root);
        }
        TreeNode dummy = root;
        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }
    public TreeNode helper(TreeNode root) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null){
                return root.left;
            } else {
                TreeNode rightChild = root.right;
                TreeNode lastRight = findLastRight(root.left);
                lastRight.right = rightChild;
                return root.left;
            }
    }
    public TreeNode findLastRight(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return findLastRight(root.right);
    }
}

