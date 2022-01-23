//206. Reverse Linked List


//https://leetcode.com/problems/reverse-linked-list/
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

//TC:O(N)  SC:O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null,nxt=null,cur=head;
        while(cur!=null){
            nxt=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nxt;
        }
        return prev;  // because now prev is the current and that is the head of the
                      //reversed linked list
    }
}
