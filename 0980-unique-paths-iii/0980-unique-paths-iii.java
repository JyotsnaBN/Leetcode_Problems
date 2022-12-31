class Solution 
{
    int res = 0, m, n;
    public int uniquePathsIII(int[][] grid) 
    {
        m = grid.length;
        n = grid[0].length;
        
        int a = 0, b = 0, x = 0, y = 0, t = 0;
    
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(grid[i][j] == 1)
                {
                    a = i;
                    b = j;
                }
                else if(grid[i][j] == 2)
                {
                    x = i;
                    y = j;
                }
                else if(grid[i][j] == 0)
                {
                    t++;
                }
            }
        }
        
        //System.out.println(m + " " + n + " " + a + " " + b + " " + x + " " + y + " " + t);
        
        func(grid, a, b, x, y, t, 0, new boolean[m][n]);
        
        
        return res;  
        
    }
    
    public void func(int grid[][], int a, int b, int x, int y, int t, int curr, boolean vis[][])
    {
        if(a>=m || a<0 || b>=n || b<0 || vis[a][b] || grid[a][b] == -1)
            return;
        
        //System.out.println(a + " " + b + " " + curr);
        
        if(a==x && b==y)
        { 
            if(curr == t)
                res++;
            return;
        }
        
        
        if(grid[a][b] == 0)
            curr++;
        vis[a][b] = true;
        
        func(grid, a+1, b, x, y, t, curr, vis);
        func(grid, a-1, b, x, y, t, curr, vis);
        func(grid, a, b+1, x, y, t, curr, vis);
        func(grid, a, b-1, x, y, t, curr, vis);
        
        vis[a][b] = false;
        curr--;
        
    }
}






















