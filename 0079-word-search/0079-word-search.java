class Solution 
{
    int m, n;
    public boolean exist(char[][] board, String word) 
    {
        m = board.length;
        n = board[0].length;
        boolean dp[][] = new boolean[m][n];
        //Set<String> set = new HashSet<String> ();
        char c = word.charAt(0);
        
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(board[i][j] == c && word.length()>1 && func(i, j, board, word, dp))
                    return true;
                else if(board[i][j] == c && word.length()==1)
                    return true;
            }
        }
        return false;        
    }
    
    public boolean func(int i, int j, char board[][], String w, boolean dp[][])
    {
        //System.out.println(i + "  " + j + "  " + w);
        if(i<0 || j<0 || i>=m || j>=n || dp[i][j] == true || board[i][j]!=w.charAt(0))
            return false;
        if(w.length() == 1)
            return true;
        
        w = w.substring(1);
        dp[i][j] = true;
        boolean res = func(i+1, j, board, w, dp) || func(i-1, j, board, w, dp) || func(i, j+1, board, w, dp) || func(i, j-1, board, w, dp);
        dp[i][j] = false;
        return res;
    }
}