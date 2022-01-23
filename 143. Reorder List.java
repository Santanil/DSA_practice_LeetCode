//143. Reorder List
//https://leetcode.com/problems/reorder-list/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0
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

//Intution: 
// 1.find the middle element
// 2.reverse the list that exists after the middle element(ie reverse the 2nd part of the LL)
// 3.update the end pointer of the 1st half if LL to Null
// 4.iterate and point the 1st node of 1st half of the LL to 1st node of 2nd half of LL and then the next pointer of the 1st node f 2nd Ll to 2nd node of 1st LL
//TC: O(N)/O(N/2)?  SC: O(1)
class Solution {
    public ListNode mid(ListNode head){
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head){
        ListNode curr=head,pre=null,next=null;
        if(head==null)
            return head;
        while(curr!=null){
            next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
    public void reorderList(ListNode head) {
        ListNode x,y,xnext,ynext,middleNode,reverseHead;
        middleNode=mid(head);
        reverseHead=reverseList(middleNode.next);
        ListNode a=reverseHead;
        middleNode.next=null;
        x=head;
        y=reverseHead;
        while(y!=null){
            xnext=x.next;
            ynext=y.next;
            x.next=y;
            y.next=xnext;
            x=xnext;
            y=ynext;
        }
    }
}
