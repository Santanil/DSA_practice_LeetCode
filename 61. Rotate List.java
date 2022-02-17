//61. Rotate List
//https://leetcode.com/problems/rotate-list/
//https://www.youtube.com/watch?v=9VPm6nEbVPA&t=460s
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0)
            return head;
        int length=0;
        ListNode tail=new ListNode();
        ListNode cur=head;
        tail.next=cur;
        while(cur!=null){
            tail=tail.next;
            cur=cur.next;
            length++;
        }
        tail.next=head;
        k=(k%length);
        k=length-k;//important step
        cur=head;
        while(k!=1){
            cur=cur.next;
            k--;
        }
        head=cur.next;
        cur.next=null;
        
        
        return head;
    }
}
