class Solution 
{
    public String countAndSay(int n) 
    {
        String s = "1";
        for(int i = 2; i<=n; i++)
        {
            s = say(s);
        }
        return s;
    }
    public String say(String s)
    {
        int n = s.length();
        int k = 1;
        char c = s.charAt(0);
        String str = "";
        if(n==1)
        {
            str = ""+k+""+s;
            return str;
        }
        for(int i = 1; i<n; i++)
        {
            if(s.charAt(i)==c)
            {
                k++;
            }
            else
            {
                str += ""+k+""+c;
                k = 1;
                c = s.charAt(i);
            }
        }
        str += ""+k+""+c;
        
        return str;
    }
}