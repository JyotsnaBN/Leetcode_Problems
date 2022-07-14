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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        Stack<Integer> s1 = new Stack<Integer> ();
        Stack<Integer> s2 = new Stack<Integer> ();
        Stack<Integer> s3 = new Stack<Integer> ();
        while(l1!=null)
        {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null)
        {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode res = new ListNode();
        int rem = 0, a = 0, b = 0, sum = 0;
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            a = 0;
            b = 0;
            if(!s1.isEmpty())
                a = s1.pop();
            if(!s2.isEmpty())
                b = s2.pop();
            
            sum = a+b+rem;
            rem = sum/10;
            s3.push(sum%10);
            
        }
        ListNode curr = res;
        while(rem!=0)
        {
            s3.push(rem%10);
            rem/=10;
        }
        while(!s3.isEmpty())
        {
            curr.next = new ListNode(s3.pop());
            curr = curr.next;
        }
        
        return res.next;
        
        
    }
}