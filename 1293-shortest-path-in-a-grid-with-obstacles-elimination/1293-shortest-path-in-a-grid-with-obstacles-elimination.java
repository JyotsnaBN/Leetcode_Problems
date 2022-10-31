class Solution 
{
    int res = Integer.MAX_VALUE;
    int n, m;
    int dp[][][];
    public int shortestPath(int[][] grid, int k) 
    {
        m = grid.length;
        n = grid[0].length;
        
        boolean arr[][] = new boolean[m][n];
        
        dp = new int[m][n][k+1];
        
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
                Arrays.fill(dp[i][j], -1);
        }
        
        Arrays.fill(dp[0][0], 0);
        
        arr[m-1][n-1] = true;
        res = func(grid, m-1, n-1, k, arr);

        
        if(res == Integer.MAX_VALUE)
            return -1;
        return res;        
    }
    
    public int func(int[][] grid, int i, int j, int k, boolean arr[][])
    {
        if(i<0 || j<0 || i>=m || j>=n || k<0)
            return Integer.MAX_VALUE;
        
        if(dp[i][j][k] != -1)
            return dp[i][j][k];
        
        if(grid[i][j] == 1 && k>0)
            k--;
        
        else if(grid[i][j] == 1)
        {    
            dp[i][j][k] = Integer.MAX_VALUE;
            return dp[i][j][k];
        }
        
        //arr[i][j] = true;
        
        int a = Integer.MAX_VALUE, b =  Integer.MAX_VALUE, c = Integer.MAX_VALUE, d = Integer.MAX_VALUE;
        
        if(j-1>=0 && j-1<n && !arr[i][j-1])
        {   
            arr[i][j-1] = true;
            d = func(grid, i, j-1, k, arr);
            arr[i][j-1] = false;
        }
        
        if(j+1>=0 && j+1<n && !arr[i][j+1])
        {    
            arr[i][j+1] = true;
            c = func(grid, i, j+1, k, arr);
            arr[i][j+1] = false;
        }
        
        if(i-1>=0 && i-1<m && !arr[i-1][j])
        {    
            arr[i-1][j] = true;
            a = func(grid, i-1, j, k, arr);
            arr[i-1][j] = false;
        }
        
        if(i+1>=0 && i+1<m && !arr[i+1][j])
        {    
            arr[i+1][j] = true;
            b = func(grid, i+1, j, k, arr);
            arr[i+1][j] = false;
        }
        

        //arr[i][j] = false;
        
        
        int r = Math.min(a, Math.min(b, Math.min(c, d)));
        if(r==Integer.MAX_VALUE)
        {    
            dp[i][j][k] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        }
        
        dp[i][j][k] = r+1;
        
        return dp[i][j][k];
    }
}