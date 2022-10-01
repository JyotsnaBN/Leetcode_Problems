class Solution 
{
    public int longestContinuousSubstring(String s) 
    {
        int res = 1, t = 1;
        if(s.length()==1)
            return 1;
        char c = s.charAt(0);
        for(int i = 1; i<s.length(); i++)
        {
            c++;
            if(s.charAt(i) == c)
                t++;
            else
            {
                if(t>res)
                    res = t;
                t = 1;
                c = s.charAt(i);
            }
        }
        if(t>res)
            res = t;
        return res;
    }
}