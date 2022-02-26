//1836. Remove Duplicates From an Unsorted Linked List
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
//https://www.youtube.com/watch?v=wIB5sg_Ulx4&t=188s
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0

//If the linkedList element values are not sorted
//TC:O(N)   SC:O(N)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode cur=head;
        while(cur!=null && cur.next!=null){
            if(set.contains(cur.next.val))
                cur.next=cur.next.next;
            else{
                set.add(cur.next.val);
                cur=cur.next;
            }
        }
        return head;
    }
}
