//92. Reverse Linked List II
//https://leetcode.com/problems/reverse-linked-list-ii/
//https://www.youtube.com/watch?v=GSJuwQzKSnI&t=446s
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

//TC:O(N)   SC:O(1)
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right)
            return head;
        ListNode dummyTail,reverseTail,prev=null,cur=head,nxt=null;
        int i=1;
        while(i<left){
            prev=cur;
            cur=cur.next;
            i++;
        }
        dummyTail=prev;
        reverseTail=cur;
        while(i<=right){
            nxt=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nxt;
            i++;
        }
        if(dummyTail!=null)
            dummyTail.next=prev;
        else
            head=prev;
        
        reverseTail.next=cur;
        return head;
    }
}
