class StockSpanner 
{
    Stack<Pair<Integer, Integer>> stack;
    int i;
    public StockSpanner() 
    {
        stack = new Stack<Pair<Integer, Integer>>();
        i = 1;
    }
    
    public int next(int price) 
    {
        if(stack.isEmpty())
        {
            stack.push(new Pair(price, i++));
            return 1;
        }

        while(!stack.isEmpty() && stack.peek().getKey()<=price)
            stack.pop();
        
        int val = 0;
        if(!stack.isEmpty())
            val = stack.peek().getValue();
        
        stack.push(new Pair(price, i++));
        return i-1-val;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */