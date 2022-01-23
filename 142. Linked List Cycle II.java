//142. Linked List Cycle II
//https://leetcode.com/problems/linked-list-cycle-ii/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//TC: O(N)  SC:O(1)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                if(slow==fast)
                    return slow;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                    if(slow==fast)
                        return slow;
                }
            }
        }
        return null;
    }
}
