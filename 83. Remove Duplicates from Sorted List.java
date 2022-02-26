//83. Remove Duplicates from Sorted List
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
//https://www.youtube.com/watch?v=wIB5sg_Ulx4&t=188s
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0

//TC:O(N)   SC:O(1)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
        ListNode cur=head;
        while(cur!=null && cur.next!=null){
            if(cur.val==cur.next.val)
                cur.next=cur.next.next;
            else
                cur=cur.next;
        }
        return head;
    }
}
