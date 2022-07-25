class Solution 
{
    int n;
    boolean flag = true;
    public boolean isBipartite(int[][] graph) 
    {
        n = graph.length;
        int v[] = new int[n];
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
            dfs(graph[i][j], graph, v, v[i]);
        }
        
    }
}