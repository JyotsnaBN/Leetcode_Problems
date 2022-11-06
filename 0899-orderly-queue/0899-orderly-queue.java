class Solution 
{
    public String orderlyQueue(String s, int k) 
    {
        String res = "";
        if(k==1)
        {
            res = s;
            for(int i = 0; i<s.length(); i++)
            {
                s = s.substring(1) + s.charAt(0);
                if(res.compareTo(s)>0)
                    res = s;
            }
            
            return res;
        }
        
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        
        res = new String(arr);
        
        return res;
    }
}