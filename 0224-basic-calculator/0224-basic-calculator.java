class Solution 
{
    public int calculate(String s) 
    {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        int no = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == ' ')
                continue;
            
            if(Character.isDigit(c))
                no = 10 * no + (int)(c - '0');
            
            else if(c == '+')
            {
                res += sign * no;
                no = 0;
                sign = 1;
            }
            
            else if(c == '-')
            {
                res += sign * no;
                no = 0;
                sign = -1;
            }
            
            else if(c == '(')
            {
                stack.push(res);
                stack.push(sign);
                sign = 1;   
                res = 0;
            }
            
            
            else if(c == ')')
            {
                res += sign * no;  
                no = 0;
                res *= stack.pop();
                res += stack.pop(); 
            }
        }
        
        
        if(no != 0) 
            res += sign * no;
        
        return res;
    }
}