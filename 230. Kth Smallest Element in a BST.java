//230. Kth Smallest Element in a BST
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
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
//Intution: since inorder traversal of BST is always sorted, we will store the inoder traversal in a list and return the kth valu from the list
//TC: O(N) to iterate throght all the nodes of the list
//SC: O(N) to store all the node values in the list
class Solution {
    public List<Integer> inorder(TreeNode root, List l){
        if(root==null)
            return l;
        inorder(root.left,l);
        l.add(root.val);
        inorder(root.right,l);
        return l;
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res=new ArrayList<>();
        res=inorder(root,res);
        for(int i=0;i<res.size();i++)
            if((i+1)==k)
                return res.get(i);
        return 0;
    }
}

//Intution: Do morris traversal(inorder) to bring down the SC to O(1). while returning from each node increase the counter by 1 and check it with the value->k. If it matches then return the value of the current node
//TC: O(N)   SC:O(1)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        //List<Integer> inorder=new ArrayList<>()    ;
        TreeNode cur=root;
        int count=0;
        while(cur!=null){
            if(cur.left==null && cur.right==null)
                return cur.val;
            if(cur.left==null){  //don't have left node so add the current root node and move right
                //inorder.add(cur.val);
                count++;
                if(count==k)
                    return cur.val;
                cur=cur.right;
            }else{
                TreeNode prev=cur.left;
                while(prev.right!=null && prev.right!=cur){ //move to the right most node of the left subtree of the cur node
                    prev=prev.right;
                }
                
                if(prev.right==null){ //if the right of the rightmost node ==null then create a thread to node
                    prev.right=cur;
                    cur=cur.left;
                }else{  // thread exist so destroy it and add the cur root value and then move right
                    prev.right=null;
                    //inorder.add(cur.val);
                    count++;
                    if(count==k)
                        return cur.val;
                    cur=cur.right;
                }
            } 
        }
        return 0;
    }
}
