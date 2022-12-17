class Solution 
{
    public int evalRPN(String[] tok) 
    {
        int n = tok.length;
        Stack<String> s = new Stack<String> ();
        char op;
        int x, y, res = 0;
        for(int i = 0; i<n; i++)
        {
            if(s.isEmpty())
                s.push(tok[i]);
            else if(isNum(tok[i]))
                s.push(tok[i]);
            else
            {
                op = tok[i].charAt(0);
                x = Integer.parseInt(s.pop());
                y = Integer.parseInt(s.pop());
              
                
                switch(op)
                {
                    case '+' : res = y+x;
                                break;
                    case '-' : res = y-x;
                                break;
                    case '*' : res = y*x;
                                break;
                    case '/' : res = y/x;
                                break;
                }
                
                s.push(Integer.toString(res));
            }
            
        }
        res = Integer.parseInt(s.pop());
        return res;
        
        
        
    }
    
    public boolean isNum(String string)
    {
        try 
        {
            int Value = Integer.parseInt(string);
            return true;
        } 
        catch (NumberFormatException e) 
        { }
        return false;
    }
}