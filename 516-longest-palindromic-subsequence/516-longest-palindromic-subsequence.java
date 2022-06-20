class Solution 
{
    public int longestPalindromeSubseq(String s) 
    {
        int n = s.length();
        
        if(n==1)
            return 1;
        
        int dp[][] = new int[n][n];
        for(int i = 0; i<n; i++)
            dp[i][i] = 1;
        int j;
        for(int k = 1; k<n; k++)
        {
            for(int i = 0; i<n-k; i++)
            {
                j = i+k;
                
                
                
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                  dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);   
                    
            }
        }
        
        return dp[0][n-1];
    }
}