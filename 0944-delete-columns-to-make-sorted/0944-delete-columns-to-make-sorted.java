class Solution 
{
    public int minDeletionSize(String[] strs) 
    {
        int n = strs.length, m = strs[0].length();
        int res = 0;
        char c;
        
        for(int i = 0; i<m; i++)
        {
            c = strs[0].charAt(i);
            for(int j = 1; j<n; j++)
            {
                if(strs[j].charAt(i)<c)
                {
                    res++;
                    break;
                }
                
                c = strs[j].charAt(i);
            }
        }
        
        return res;
    }
}