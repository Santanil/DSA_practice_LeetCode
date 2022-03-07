//148. Sort List
//https://leetcode.com/problems/sort-list/ 
//https://www.youtube.com/watch?v=pNTc1bM1z-4&t=506s
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
//TC: O(N log N)
//SC: O(N)
class Solution {
    public ListNode sortList(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode tempHead=head;
        while(tempHead!=null){
            list.add(tempHead.val);
            tempHead=tempHead.next;
        }
        Collections.sort(list);
        tempHead=head;
        int i=0;
        while(tempHead!=null){
            tempHead.val=list.get(i);
            tempHead=tempHead.next;
            i++;
        }
        return head;
    }
}


//Merge Sort (Optimized Solution)
//TC:O(N log N)
//SC:O(1)
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode temp=null,slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        temp.next=null;
        ListNode first=sortList(head);
        ListNode second=sortList(slow);
        return merge(first,second);
    }
    public ListNode merge(ListNode h1,ListNode h2){
        ListNode temp=new ListNode(0);
        ListNode dummy=temp;
        while(h1!=null && h2!=null){
            if(h1.val<h2.val){
                dummy.next=h1;
                h1=h1.next;
            }else{
                dummy.next=h2;
                h2=h2.next;
            }
            dummy=dummy.next;
        }
        if(h1!=null){
            dummy.next=h1;
        }
        if(h2!=null){
            dummy.next=h2;
        }
        
        return temp.next;
    }
}
