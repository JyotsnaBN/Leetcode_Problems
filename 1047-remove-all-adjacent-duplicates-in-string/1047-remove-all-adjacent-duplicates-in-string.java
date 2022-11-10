class Solution 
{
    public String removeDuplicates(String s) 
    {
        StringBuilder res = new StringBuilder();
        int n = 0;
        for(int i = 0; i<s.length(); i++)
        {
            if(res.length() == 0)
                res.append(s.charAt(i));
            else
            {
                n = res.length();
                if(res.charAt(n - 1) == s.charAt(i))
                    res.deleteCharAt(n - 1);
                else
                    res.append(s.charAt(i));
            }
        }
        
        return res.toString();
    }
}