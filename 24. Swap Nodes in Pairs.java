//24. Swap Nodes in Pairs
//https://leetcode.com/problems/swap-nodes-in-pairs/
//https://www.youtube.com/watch?v=WYlMkut4XDw
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode();
        ListNode prev=dummy,current=head;
        dummy.next=head;
        while(current!=null && current.next!=null){
            prev.next=current.next;
            current.next=current.next.next;
            prev.next.next=current;
            current=current.next;
            prev=prev.next.next;
        }
        return dummy.next;
    }
}
