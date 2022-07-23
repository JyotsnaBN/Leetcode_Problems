class Solution 
{
    int n;
    public int findCircleNum(int[][] mat) 
    {
        n = mat.length;
        int v[] = new int[n];
        int res = 0;
        for(int i = 0; i<n; i++)
        {
            if(v[i] == 0)
            {    
                dfs(mat, i, v);
                res++;
            }
            
        }
        return res;
    }
    public void dfs(int mat[][], int i, int v[])
    {
        v[i] = 1;
        
        for(int j = 0; j<n; j++)
        {
            if(i!=j && mat[i][j] == 1 && v[j] == 0)
                dfs(mat, j, v);
        }
    }
}