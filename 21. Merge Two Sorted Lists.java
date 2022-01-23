//21. Merge Two Sorted Lists
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


class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        
        ListNode x=list1,y=list2,head,ans; //head to point the head of the LL
        
        if(x.val<y.val){
            head=x;
            x=x.next;
        }else{
            head=y;
            y=y.next;
        }
        ans=head;  //ans to point the last node to the sorted LL
        while(x!=null && y!=null){
            if(x.val<y.val){
                ans.next=x;
                x=x.next;
            }else{
                ans.next=y;
                y=y.next;
            }
            ans=ans.next;
        }
        if(x!=null)  //if all elements of y are taken but some elements of x are left
            ans.next=x;
        if(y!=null)  //if all elements of x are taken but some elements of y are left
            ans.next=y;
        return head;
    }
}
