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
*************************************************Not Optimized*********************************************
//TC:O(N)   SC:O(N)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hs=new HashSet<>();
        ListNode cur=headA;
        while(cur!=null){
            hs.add(cur);
            cur=cur.next;
        }
        cur=headB;
        while(cur!=null){
            if(hs.contains(cur))
                return cur;
            cur=cur.next;
        }
        return null;
    }
}


****************************************Not Optimized Single PASS*******************************************
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hs=new HashSet<>();
        ListNode hA=headA,hB=headB;
        while(hA!=null || hB!=null){
            if(hA!=null && hs.contains(hA))
                return hA;
            else if(hA!=null)
                hs.add(hA);
            if(hB!=null && hs.contains(hB))
                return hB;
            else if(hB!=null)
                hs.add(hB);
            if(hA!=null)
                hA=hA.next;
            if(hB!=null)
                hB=hB.next; 
        }
        return null;     
    }
}

*********************************************Optimized*******************************************************
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


*********************************************Optimized 2*********************************************

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode hA=headA,hB=headB;
        while(hA!=hB){
            if(hA==null)
                hA=headB;
            else
                hA=hA.next;
            if(hB==null)
                hB=headA;
            else
                hB=hB.next; 
        }
        return hA;     
    }
}
