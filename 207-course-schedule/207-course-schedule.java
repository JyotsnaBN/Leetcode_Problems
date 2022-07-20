class Solution 
{
    int n;
    public boolean canFinish(int no, int[][] mat) 
    {
        n = no;
        int arr[][] = new int[n][n];
        int v[] = new int[n];
        int dv[] = new int[n];
        
        for(int i = 0; i<mat.length; i++)
        {
            int a = mat[i][0];
            int b = mat[i][1];
            arr[a][b] = 1;
        }
        for(int i = 0; i<n; i++)
        {
            if(v[i]==0)
            {
                if(func(i, arr, v, dv) == false)
                    return false;
            }
            
        }
        return true;
    }
    public boolean func(int i, int[][] arr, int v[], int dv[])
    {
        v[i] = 1;
        dv[i] = 1;
        for(int j = 0; j<n; j++)
        {
            if(arr[i][j] == 0)
                continue;
            if(v[j] == 0)
            {
                if(func(j, arr, v, dv) == false)
                    return false;
            }
            else if(dv[j] == 1)
                return false;
        }
        dv[i] = 0;
        return true;
    }
}