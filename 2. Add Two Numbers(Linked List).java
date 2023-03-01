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
        ListNode l1Head=l1,l2Head=l2,ptr=null;
        ListNode tempHead=new ListNode(-1);
        ptr=tempHead;
        int sum=0,carry=0;
        while(l1Head!=null || l2Head!=null){

            if(l1Head==null)
                sum=(l2Head.val+carry);
            else if(l2Head==null)
                sum=(l1Head.val+carry);
            else
                sum=(l1Head.val+l2Head.val+carry);
            carry=sum/10;
            ListNode node=new ListNode(sum%10);
            ptr.next=node;
            ptr=ptr.next;
            if(l1Head!=null) l1Head=l1Head.next;
            if(l2Head!=null) l2Head=l2Head.next;
        }
        if(carry>0){
            ListNode node=new ListNode(carry);
            ptr.next=node;
            ptr.next.next=null;
        }
        return tempHead.next;    
    }
}
