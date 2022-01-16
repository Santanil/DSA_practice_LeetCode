//138. Copy List with Random Pointer
//https://leetcode.com/problems/copy-list-with-random-pointer/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/


// TC: O(N)   SC:O(1)
// class Solution {
//     public Node copyRandomList(Node head) {
//         HashMap<Node,Node> hm=new HashMap<Node,Node>();
//         if(head==null)
//             return null;
//         Node x=head; 
//         Node copyHead=new Node(head.val);
//         Node y=copyHead;
//         hm.put(x,y);
//         //iterating untill the whole copy of the LinkedList is complete
//         while(x.next!=null){
//             x=x.next;
//             Node newNode=new Node(x.val);
//             y.next=newNode;
//             y=y.next;
//             hm.put(x,y);
//         }
//         y.next=null;
//         x=head;
//         while(x!=null){
//             hm.get(x).random=hm.get(x.random);  
//             x=x.next;                 
//         }
//         return copyHead;
//     }
// }


//Optimized:
//TC:O(N)   SC:O(1)
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Node x=head,pre=null; 
        Node copyHead=new Node(head.val);
        Node y=copyHead;
        pre=x.next;
        x.next=y;
        y.next=pre;
        //iterating untill the whole copy of the LinkedList is complete
        while(x.next.next!=null){
            x=x.next.next;
            Node newNode=new Node(x.val);
            pre=x.next;
            x.next=newNode;
            newNode.next=pre;
        }
        //y.next=null;
        x=head;
        //while(x.next!=null && x.next.next!=null){
        while(x!=null){
            if(x.random==null)
                x.next.random=null;
            else
                x.next.random=x.random.next;
            x=x.next.next;                
        }
        x=head;
        y=copyHead;
        while(y.next!=null){
            x.next=x.next.next;
            y.next=y.next.next;
            x=x.next;
            y=y.next;
        }
        x.next=null;
        return copyHead;
    }
}
