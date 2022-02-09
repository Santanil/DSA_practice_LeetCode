//2. Add Two Numbers
//https://leetcode.com/problems/add-two-numbers/
//https://www.youtube.com/watch?v=LBVsXSMOIk4
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

//TC: O(N)  SC:O(1)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode();
        ListNode cur=head;
        int carry=0,sum=0;
        while(l1!=null || l2!=null || carry!=0){
            ListNode temp=new ListNode();
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            sum+=carry;
            carry=sum/10;
            temp.val=sum%10;
            sum=0;
            cur.next=temp;
            cur=cur.next;
        }
        return head.next;
    }
}
