https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

****************************Naive 2pass solution****************************************
TC: O(2N)
SC: O(1)
  

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        
        if(head.next==null)
            return head.next;
        
        ListNode ptr=head;
        int l=1;
        while(ptr.next!=null){
            ptr=ptr.next;
            l++;
        }
        
        l=l/2;
        ptr=head;
        for(int i=1;i<l;i++){
            ptr=ptr.next;
        }
        ptr.next=ptr.next.next;
        
        return head;
    }
}


******************************  1 PASS solution *******************************


class Solution {
    public ListNode deleteMiddle(ListNode head) {
        
        if(head.next==null)
            return head.next;

        ListNode slow=new ListNode(0);
        slow.next=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;
        
        return head;
    }
}
