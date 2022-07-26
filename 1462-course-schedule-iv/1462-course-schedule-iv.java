class Solution 
{
    int n;
    boolean v[];
    boolean arr[][];
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] pre, int[][] queries) 
    {
        n = numCourses;
        arr = new boolean[n][n];
        v = new boolean[n];
        
        for(int i = 0; i<pre.length; i++)
        {
            int a = pre[i][0], b = pre[i][1];
            arr[a][b] = true;
        }
        for(int i = 0; i<n; i++)
            arr[i][i] = true;
        for(int i = 0; i<n; i++)
        {
            if(!v[i])
                dfs(i);
        }
        List<Boolean> res = new ArrayList<Boolean> ();
        for(int i = 0; i<queries.length; i++)
        {
            if(arr[queries[i][0]] [queries[i][1]]    )
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
    
    public void dfs(int i)
    {
        if(v[i])
            return;
        v[i] = true;
        
        for(int j = 0; j<n; j++)
        {
            if(arr[i][j])
            {
                dfs(j);
                for(int k = 0; k<n; k++)
                {
                    if(arr[j][k])
                        arr[i][k] = true;
                }
            }
        }
    }
}