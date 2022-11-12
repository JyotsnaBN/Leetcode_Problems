class MedianFinder 
{
    List<Integer> list;
    int size, index;
    
    public MedianFinder() 
    {
        list = new ArrayList<Integer> ();
        size = 0;
        index = 0;
    }
    
    public void addNum(int num) 
    {       
        if(size == 0) 
            list.add(num);       
        else if(num>list.get(size-1))
            list.add(num);
        else if(num<list.get(0))
            list.add(0, num);
        else
        {
            index = Collections.binarySearch(list, num);
            //System.out.print(index + "  ");
            if(index<0)
            {    
                index*=-1;
                index--;
            }
            
            list.add(index, num);
        }
        size++;
        
        //System.out.println(size + "  " + list);
    }
    
    public double findMedian() 
    {
        if(size%2==0)
        {
            return ((double)list.get(size/2) + (double)list.get((size/2) - 1))/2.0;
        }
        return (double)list.get(size/2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/*
class MedianFinder 
{
    double med;
    ListNode list, mid, tail;
    
    boolean flag;
    
    public MedianFinder() 
    {
        med = 0.0;
        list = new ListNode();
        mid = null;
        tail = null;
        flag = true;//even - true, odd - false
    }
    
    public void addNum(int num) 
    {
        ListNode curr = new ListNode(num);
        flag = (flag)? false : true;
        
        if(mid == null)
        {
            list = curr;
            tail = curr;
            mid = curr;
            med = num;
            return;
        }
        
        
        tail.next = curr;
        tail = tail.next;
        
        if(flag)
        {
            mid = mid.next;
            med = (med + mid.val)/2;
        }
        else
        {
            med = mid.val;
        }
        //System.out.println(num + " " + flag + " " + mid.val + " " + med);
    }
    
    public double findMedian() 
    {
        return med;
    }
}

public class ListNode 
{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) 
    { 
        this.val = val; 
    }
    ListNode(int val, ListNode next) 
    { 
        this.val = val; 
        this.next = next; 
    }
}
*/