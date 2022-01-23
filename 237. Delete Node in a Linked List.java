//237. Delete Node in a Linked List
//https://leetcode.com/problems/delete-node-in-a-linked-list/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0
//https://www.youtube.com/watch?v=bJPmNKMtjdk


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//Intution: Since the head node is not given and its a sigly linked list, so can't delete the head node.
//therefore we are copying the data from the next node to the node to be deleted and deleting the next node instead

//TC: O(1)  SC: O(1)
class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
