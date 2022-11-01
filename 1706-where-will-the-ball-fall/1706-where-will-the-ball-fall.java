class Solution 
{
    public int[] findBall(int[][] grid) 
    {
        int m = grid.length, n = grid[0].length;
        int res[] = new int[n];
        Arrays.fill(res, -1);
        
        
        for(int k = 0; k<n; k++)
        {
            int i = 0, j = k;
            
            while(i<=m && j>=0 && j<n)
            {
                if(i == m)
                {
                    res[k] = j;
                    break;
                }
                if(grid[i][j] == 1 && j!=n-1 && grid[i][j+1] == 1)
                {
                    i++;
                    j++;
                }
                else if(grid[i][j] == 1 && j!=n-1 && grid[i][j+1] == -1)
                {
                    break;
                }
                else if(grid[i][j] == -1 && j!=0 && grid[i][j-1] == -1)
                {
                    i++;
                    j--;
                }
                else if(grid[i][j] == -1 && j!=0 && grid[i][j-1] == 1)
                {
                    break;
                }
                else if(j==n-1 || j==0)
                {
                    break;
                }

            }
        }
        
        return res;
        
    }
}