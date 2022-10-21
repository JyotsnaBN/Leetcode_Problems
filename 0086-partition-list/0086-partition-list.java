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
class Solution 
{
    public ListNode partition(ListNode head, int x) 
    {
        if(head == null)
            return head;
        if(head.next==null)
            return head;
        ListNode less = new ListNode(head.val);
        ListNode more = new ListNode(head.val);
        ListNode l1 = less, l2 = more;
        //System.out.println("a");
        while(head!=null)
        {
            if(head.val < x)
            {
                less.next = new ListNode(head.val);
                less = less.next;
            }
            else
            {
                more.next = new ListNode(head.val);
                more = more.next;
            }
            
            head = head.next;
        }
        //System.out.println("b");
        
        l2 = l2.next;
        
        less.next = l2;
        more.next = null;
        ListNode curr = l1;
        int i = 0;
        while(i<20 && curr!=null)
        {
            //System.out.print(curr.val + " ");
            curr = curr.next;
            i++;
        }
        return l1.next;
        
    }
}