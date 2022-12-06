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
    public ListNode oddEvenList(ListNode head) 
    {
        if(head == null || head.next == null || head.next.next == null)
            return head;
        
        ListNode temp = new ListNode(0);
        ListNode temp1 = temp;
        ListNode curr = head;
        boolean flag = false;

        while(curr.next!=null)
        {
            temp.next = curr.next;
            temp = temp.next;      
            if(curr.next.next!=null)
                curr.next = curr.next.next;  
            temp.next = null;
            if(curr.next!=temp)
                curr = curr.next;
            else
                curr.next = null;
        }
        
        curr.next = temp1.next;
        
        return head;
    }
}