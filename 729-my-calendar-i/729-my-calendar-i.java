class MyCalendar 
{
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public MyCalendar() 
    {
        
    }
    
    public boolean book(int start, int end) 
    {
        if (map.containsKey(start))
            return false;
        var low = map.lowerEntry(start);
        var high = map.higherEntry(start);
     
        if ( (low  == null || start >= low.getValue()) &&  (high == null || end <= high.getKey()) ) 
        {
            map.put(start, end);
            return true;
        }
        
        return false;
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */