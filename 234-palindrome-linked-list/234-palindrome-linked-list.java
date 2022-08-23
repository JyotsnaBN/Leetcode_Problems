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
    public boolean isPalindrome(ListNode head) 
    {
        /*Method 1 - create a list and iterate from both directions
        List<Integer> list = new ArrayList<Integer> ();
        while(head!=null)
        {
            list.add(head.val);
            head = head.next;
            
        }
        for(int i = 0; i<list.size(); i++)
        {
            if(list.get(i)!=list.get(list.size() - 1 - i))
                return false;
        }
        return true;*/
        
        //Method 2 - find mid element(fast and slow pointer...) then reverse the 2nd half of the list.... then compare
        ListNode fast = head, slow = head;
        while(fast!=null && fast.next!=null && fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode res = new ListNode();
        
        while(slow!=null)
        {
            ListNode temp = slow.next;
            slow.next = res;
            res = slow;
            slow = temp;
        }
        
        while(res.next!=null && head.next!=null)
        {
            System.out.println(res.val + " " + head.val);
            if(res.val!=head.val)
                return false;
            res = res.next;
            head = head.next;
        }
        return true;
        
        
    }
}