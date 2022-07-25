class Solution 
{
    int n;
    boolean flag = true;
    public boolean possibleBipartition(int no, int[][] dislikes) 
    {
        n = no + 1;
        int v[] = new int[n];
        int graph[][] = new int[n][n];
        for(int i = 0; i<dislikes.length; i++)
        {
            int a = dislikes[i][0], b = dislikes[i][1];
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        for(int i = 0; i<n; i++)
        {
            if(v[i] == 0)
            {
                dfs(i, graph, v, 1);
                if(!flag)
                    return false;
            }
        }
        return true;
    }
    public void dfs(int i, int graph[][], int v[], int prev)
    {
        if(v[i]==prev)
        {
            flag = false;
            return;
        }
        if(v[i]!=0)
            return;
        
        v[i] = prev==1? 2 : 1;
        
        for(int j = 0; j<graph[i].length; j++)
        {
            if(graph[i][j] == 1)
                dfs(j, graph, v, v[i]);
        }
        
    }
    
}