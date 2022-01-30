//662. Maximum Width of Binary Tree
//https://leetcode.com/problems/maximum-width-of-binary-tree/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0
//https://www.youtube.com/watch?v=ZbybYvcVLks

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
//Intution: to store the currNode value along with the node index. And using the index we will be able to find the maximum width of the binary tree
//TC: O(N)  SC:O(N)
class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode node,int num){
        this.node=node;
        this.num=num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();    
        q.add(new Pair(root,0));
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            int first=0,last=0;
            int min=q.peek().num;
            for(int i=0;i<size;i++){
                TreeNode currNode=q.peek().node;
                //int curNum=q.peek().num;
                int curNum=q.peek().num-min; //if the num of node is more than 10^5 the it will be a overflow as the curNum value is doubling on each level, so this is optimisatio using which for each level the curNum value will start from (current index-min of prev elvel curNum)
                q.poll();
                if(i==0)
                    first=curNum;
                if(i==size-1)
                    last=curNum;
                if(currNode.left!=null)
                    q.offer(new Pair(currNode.left,curNum*2+1));
                if(currNode.right!=null)
                    q.offer(new Pair(currNode.right,curNum*2+2));
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}

