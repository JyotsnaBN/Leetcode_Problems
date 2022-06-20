class Solution 
{
    public String longestPalindrome(String s) 
    {
        int n = s.length();
        
        if(n==1)
            return s;
        
        String res = "" + s.charAt(0);
        int max = 1;
        int dp[][] = new int[n][n];
        for(int i = 0; i<n; i++)
            dp[i][i] = 1;
        int j;
        for(int k = 1; k<n; k++)
        {
            for(int i = 0; i<n-k; i++)
            {
                j = i+k;
                //System.out.println("i = " + i +"  j = " + j);
                //System.out.println(s.charAt(i) + "  " + s.charAt(j) + " " + dp[i+1][j-1] + "  " +  (j-i-1)   );
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == j-i-1)
                {    
                    //System.out.println(j-i-1);
                    dp[i][j] = dp[i+1][j-1] + 2;
                    if(dp[i][j]>max)
                    {
                        max = dp[i][j];
                        res = s.substring(i, j+1);
                    }
                }
                else
                   dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]); 
                    
            }
        }
        
        return res;
    }
}