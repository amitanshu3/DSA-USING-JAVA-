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
    public ListNode middleNode(ListNode head) {
        
       /* ListNode temp=head;
        int size=1;
        while(temp.next!=null)
        {
            temp=temp.next;
            size++;
        }
        size=size/2+1;
        temp=head;
        for(int i=0;i<size-1;i++)
        {
            temp=temp.next;
        }
        return temp;*/

        //slow and fast approach

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
