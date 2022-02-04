//116. Populating Next Right Pointers in Each Node
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

//Intution: Do level order traversal and if the current node is not the end node for that level before dequeing the node update the node's next pointer to the next element in the queue and if its the end node for that level then just poll the element as for all nodes the next pointer is by default pointing to null
//TC:O(N)  SC:O(N)
class Solution {
    public Node connect(Node root) {
        if(root==null)
            return null;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize=q.size()-1;
            for(int i=0;i<=levelSize;i++){
                if(q.peek().left!=null)
                    q.offer(q.peek().left);
                if(q.peek().right!=null)
                    q.offer(q.peek().right);
                if(i!=levelSize)
                    q.poll().next=q.peek();
                else
                    q.poll();
            }
        }
        return root;
    }
}



