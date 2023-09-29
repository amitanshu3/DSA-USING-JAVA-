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
    public ListNode reverseList(ListNode head) {
       
       //MY OWN CODE
       /* if(head==null)
          return head;
        
        ListNode temp=head;
        ListNode temp2=head.next;
        if(temp2==null)
         return head;
        ListNode temp3=head.next;
        int i=0;
        while(temp2!=null)
        {
            temp2=temp2.next;
            temp3.next=temp;
            if(i==0)
            {
                temp.next=null;
                i++;
            }
            temp=temp3;
            if(temp2!=null)
            temp3=temp2;
        }
        head=temp3;
        return head;*/

        //LEETCODE SOLUTION
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null)
        {
            ListNode temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }

      return prev;
        

    }
}
