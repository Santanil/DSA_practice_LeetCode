//160. Intersection of Two Linked Lists
//https://leetcode.com/problems/intersection-of-two-linked-lists/
//https://www.youtube.com/watch?v=u4FWXfgS8jw
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//Not Optimized
//TC:O(N)   SC:O(N)
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         HashSet<ListNode> hs=new HashSet<>();
//         ListNode cur=headA;
//         while(cur!=null){
//             hs.add(cur);
//             cur=cur.next;
//         }
//         cur=headB;
//         while(cur!=null){
//             if(hs.contains(cur))
//                 return cur;
//             cur=cur.next;
//         }
//         return null;
//     }
// }


//Optimized
//TC: O(N)   SC:O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dA=headA,dB=headB;
        while(dA!=dB){
            dA= dA==null?headB:dA.next;
            dB= dB==null?headA:dB.next;
        }
        return dA;
    }
}
