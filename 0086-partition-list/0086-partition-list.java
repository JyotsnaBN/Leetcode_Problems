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




//Time complexity - O(n)
//Space Complexity - O(1)
class Solution 
{
    public ListNode partition(ListNode head, int x) 
    {
        if(head == null)
            return head;
        if(head.next==null)
            return head;
        
        
        ListNode og = new ListNode(0);
        og.next = head;
        head = og;//Create a dummy node and add it before the 1st node and start traversal from the dummy node
        
        ListNode n = new ListNode(0);
        ListNode temp = n;//Create a new List for values greater than or equal to x
        
        while(head.next!=null)
        {
            if(head.next.val >= x)//In the original list, only keep values less than x
            {
                n.next = head.next;
                n = n.next;
                head.next = head.next.next;
                n.next = null;
            }
            else
            {
                head = head.next;
            }
            
        }
        
        head.next = temp.next;
        
        return og.next;
        
    }
}







/*
Time complexity - O(n)
Space complexity - O(n)


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
}*/