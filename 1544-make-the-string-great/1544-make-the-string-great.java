class Solution 
{
    public String makeGood(String s) 
    {
        Stack<Character> stack = new Stack<Character>();
        
        char c;
        for(int i = 0; i<s.length(); i++)
        {
            c = s.charAt(i);
            if(stack.isEmpty())
            {
                stack.push(c);
                continue;
            }
            if((Character.isUpperCase(c) && Character.toLowerCase(c) == stack.peek())  ||   (Character.isLowerCase(c) && Character.toUpperCase(c) == stack.peek()))
                stack.pop();
            else
                stack.push(c);
                
        }
        
        String res = "";
        
        while(!stack.isEmpty())
            res = stack.pop() + res;
        
        return res;
    }
}