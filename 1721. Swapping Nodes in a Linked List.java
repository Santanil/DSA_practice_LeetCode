//1721. Swapping Nodes in a Linked List
//https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
//https://www.youtube.com/watch?v=OZmCvMsFgDA
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//Intution: firstK-> to store the kth node form 1st. Now once the kth node from 1st is reached, create a new pointer ptr that points to head and keep travelling through the list untill firstK.next=null, once it reaches null means the ptr reaches the kth pointer from the end. Now interchange the values of the two nodes
//TC:O(N)  SC:O(1)
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp=new ListNode();
        temp.next=head;
        ListNode ptr,firstK=head,lastK;
        int i=1,firstKVal;
        while(i<k){
            firstK=firstK.next;
            i++;
        }
        firstKVal=firstK.val;
        ptr=firstK;
        lastK=head;
        while(ptr.next!=null){
            ptr=ptr.next;
            lastK=lastK.next;
        }
        firstK.val=lastK.val;
        lastK.val=firstKVal;
        return head;
    }
}
