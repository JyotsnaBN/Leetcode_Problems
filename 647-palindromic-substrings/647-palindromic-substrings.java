class Solution 
{
    public int countSubstrings(String s) 
    {
        int n = s.length();
        int dp[][] = new int[n][n];
        
        int res = n;
        for(int i = 0; i<n; i++)
            dp[i][i] = 1;
        int j;
        for(int k = 1; k<n; k++)
        {
            for(int i = 0; i<n-k; i++)
            {
                j = i+k;
                
                if(s.charAt(i) == s.charAt(j) && (dp[i+1][j-1] == 1|| i+1==j))
                {    
                    dp[i][j] = 1;
                    res++;
                }
                else
                   dp[i][j] = 0; 
                    
            }
        }
        
        
        return res;
    }
}