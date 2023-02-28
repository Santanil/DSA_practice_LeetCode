//19. Remove Nth Node From End of List
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
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
//Intution: run a loop from head to nth node, create another pointer to head and start updating both the pointers by one untill the end pointer crosses the last node-> point being the difference b/w the 1st and the nth(end) pointer will be n so we will be able to mark the nth node that way
//TC:O(N)  SC:O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pF=head,pS=null,pT=null;
        for(int i=0;i<n;i++)
            pF=pF.next;
        pS=head;
        while(pF!=null){
            pT=pS;
            pF=pF.next;
            pS=pS.next;
        }
        if(pT==null) //head needs to be removed
            return head.next;
        else
            pT.next=pS.next;
        return head;
    }
}
