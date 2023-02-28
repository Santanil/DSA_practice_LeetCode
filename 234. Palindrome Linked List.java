//234. Palindrome Linked List
//https://leetcode.com/problems/palindrome-linked-list/
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
//Naive approach
to copy the values of the lists in an array and check if the array is palindromic or not
TC: O(N)+O(N)  for iterating through the list once + iterating through the array to check if its palindromic
SC: O(N) to store N elements of the List in an array



//Optimized   TC: O(N/2)+O(N/2)+O(N/2)
            //1st O(N/2): for finding the mid element
            //2nd O(N/2): for reveresing the 2nd half of the linkedList
            //3rd O(N/2): for checking the 1st half of the list and the 2nd half(reversed half) of the list 
public class Solution {
    boolean checkPalindrome(ListNode head1,ListNode head2){
        while(head2!=null){
            if(head1.val!=head2.val)
                return false;
            head1=head1.next;
            head2=head2.next;
        }
        return true;
    }
    ListNode reverseList(ListNode listHead){
        ListNode x=listHead,y=listHead.next,pre=null;
        if(y==null)
            return listHead;
        while(x!=null){
            y=x.next;
            x.next=pre;
            pre=x;
            x=y;
        }
        return pre;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return false;
        if(head.next==null)
            return true;
        ListNode slow=head,fast=head,secondListHead=null;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        secondListHead=reverseList(slow.next);
        fast=head;
        if(checkPalindrome(fast,secondListHead))
            return true;
        else
            return false;
    }
}




************************************************Consise Code*************************************************
class Solution {
    public ListNode reverseList(ListNode head){
        ListNode prev=null,cur=head,nxt=null;
        while(cur!=null){
            nxt=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nxt;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head.next==null)
            return true;
        ListNode prev=null,slow=head,fast=head,firstListHead=head,secondListHead=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        secondListHead=reverseList(slow);

        while(firstListHead!=null){
            if(firstListHead.val!=secondListHead.val)
                return false;
            firstListHead=firstListHead.next;
            secondListHead=secondListHead.next;
        }
        return true;    
    }
}
