//141. Linked List Cycle
//https://leetcode.com/problems/linked-list-cycle/
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
*******************************BF approach********************************** 
//TC:O(N)  SC:O(N)
//Using HashSet
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hs=new HashSet<>();
        while(head!=null){
            if(hs.contains(head))
                return true;
            else
                hs.add(head);
            head=head.next;
        }
        return false;    
    }
}

*******************************Best/Optimized approach**********************************
 //TC: O(N)   SC:O(1)
 //Using slow and fast pointer technique
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;
    }
}
