//86. Partition List
//https://leetcode.com/problems/partition-list/
//https://www.youtube.com/watch?v=K5AVJVjdmL0
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
//Intution: Create 2 dummy heads for low and high values and keep adding the nodes to the respective lists untill head is null. Now update the last pointer of the high LL ie after to null and point next of low LL ie before to afterHead's next as afterHead is a dummy node. Finally return the low LL's next pointer(beforeHead.next) as neforeHead is a dummy node
//TC:O(N)   SC:O(1)
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null)
            return null;
        ListNode beforeHead=new ListNode();
        ListNode before=beforeHead;
        ListNode afterHead=new ListNode();
        ListNode after=afterHead;
        while(head!=null){
            if(head.val<x){
                before.next=head;
                before=before.next;
            }else{
                after.next=head;
                after=after.next;
            }
            head=head.next;
        }
        after.next=null;
        before.next=afterHead.next;
        return beforeHead.next;
    }
}
