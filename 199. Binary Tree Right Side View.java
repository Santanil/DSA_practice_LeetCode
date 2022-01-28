//199. Binary Tree Right Side View
//https://leetcode.com/problems/binary-tree-right-side-view/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0
//https://www.youtube.com/watch?v=KV4mRzTjlAk


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
//Intution: doing a level order traversal Left->Root->Right and storing the updated value in the var lastData and finally adding it to the list after every level traversal is complete
//TC:O(N)  SC:O(H) normally but for skewed tree SC:O(N)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size(),lastData=0;
            for(int i=0;i<size;i++){
                TreeNode front=q.peek();
                if(front.left!=null)
                    q.offer(front.left);
                if(front.right!=null)
                    q.offer(front.right);
                lastData=front.val;
                q.remove(front);
            }
            list.add(lastData);
        }
        return list;
    }
}


//Faster code 
//Intution: to recursively traverse thought the tree by Right->Root->Left and if at any point current depth=list size add it to our resultant list
//TC: O(N)  SC:O(H) normally but for skewed tree SC:O(N)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        rightView(root,list,0);
        return list;
    }
    public void rightView(TreeNode root,List list,int currDepth){
        if(root==null)
            return;
        if(currDepth==list.size()){
            list.add(root.val);
        }
        rightView(root.right,list,currDepth+1);
        rightView(root.left,list,currDepth+1);
    }
}

