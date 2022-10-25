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
    public ListNode mergeKLists(ListNode[] lists) 
    {
        ListNode res = new ListNode(-1000000);
        res.next = new ListNode(-1000000);

        ListNode temp = res;
        int n = lists.length;

        for(int i = 0; i<n; i++)
        {
            temp = res;
            ListNode curr = lists[i];

            while(curr!=null)
            {
                while(temp.next!=null && temp.next.val<curr.val)
                {

                    temp = temp.next;
                }

                ListNode temp2 = curr;
                curr = curr.next;
                temp2.next = temp.next;
                temp.next = temp2;
            } 
        }
        return res.next.next;
    }
}