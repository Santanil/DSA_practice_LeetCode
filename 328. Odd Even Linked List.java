//328. Odd Even Linked List
//https://leetcode.com/problems/odd-even-linked-list/
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

//Intution: Create 2 dummy heads for odd and even indices and keep adding the nodes to the respective lists untill head is null. Now update the last pointer of the even LL ie after to null and point next of off LL ie before to afterEven's next as afterEven is a dummy node. Finally return the odd LL's next pointer(beforeOdd.next) as beforeOdd is a dummy node
//TC:O(N)   SC:O(1)
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode beforeOdd=new ListNode();
        ListNode curOdd=beforeOdd;
        ListNode beforeEven=new ListNode();
        ListNode curEven=beforeEven;
        int i=1;
        while(head!=null){
            if(i%2==0){
                curEven.next=head;
                curEven=curEven.next;
            }else{
                curOdd.next=head;
                curOdd=curOdd.next;
            }
            head=head.next;
            i++;
        }
        curEven.next=null;
        curOdd.next=beforeEven.next;
        return beforeOdd.next;
    }
}
