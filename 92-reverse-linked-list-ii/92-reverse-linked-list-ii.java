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
    public ListNode reverseBetween(ListNode head, int left, int right) 
    {
        ListNode finalRes = new ListNode(1000);
        ListNode lN =  head, rN = head;
        int i = 1;
        ListNode curr = head, prev = finalRes;
        while(curr!=null)
        {
            if(i<left)
                prev = curr;
            if(i==left)
                lN = curr;
            if(i==right)
            {
                rN = curr;
                break;
            }
            i++;
            
            curr = curr.next;
        }
        //System.out.println(lN.val + "  " + rN.val + "  " + prev.val);
        ListNode nextNode = rN.next;
        prev.next = reverseList(lN, rN);
        curr = prev.next;
        i = 1;
        while(i<=right-left)
        {    
            curr = curr.next;
            i++;
        }
        curr.next = nextNode;
        if(left == 1)
            return finalRes.next;
        return head;
        
    }
    public ListNode reverseList(ListNode head, ListNode end) 
    {
        ListNode curr = head, prev = null;
        end.next = null;
        while(curr!=null)
        {
            //System.out.println(curr.val);
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        //System.out.println("--");
        curr = prev;
        while(curr!=null)
        {
            //System.out.println(curr.val);
            curr = curr.next;
        }
        //System.out.println("--");
        return prev;
    }
}