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
        ListNode pre=null,temp=head,end=head;
        int i=1;
        while(i<=n){
            end=end.next;
            i++;
        }
        while(end!=null){
            pre=temp;
            temp=temp.next;
            end=end.next;
        }
        if(pre==null) //if pre is null that means the 1st node is the nth node from end that is to be removed so we can simply return the next of head
            return head.next;
        pre.next=temp.next;
        return head;
    }
}
