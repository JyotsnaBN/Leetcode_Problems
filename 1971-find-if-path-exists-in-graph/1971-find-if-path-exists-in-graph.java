class Solution 
{
    int d;
    public boolean validPath(int n, int[][] edges, int source, int des) 
    {
        if(source == des)
            return true;
        d = des;
        Map<Integer,List<Integer>> graph = new HashMap();
        for(int i = 0 ; i < n ; i++) 
            graph.put(i, new ArrayList());
        
        for(int i = 0; i<edges.length; i++)
        {
            int a = edges[i][0], b = edges[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int v[] = new int[n];
        dfs(n, source, graph, v);
        if(v[des]==1)
            return true;
        return false;
    }
    
    public void dfs(int n, int i, Map<Integer,List<Integer>> graph, int v[])
    {
        if(v[i] == 1)
            return;
        v[i] = 1;
        if(graph.get(i).contains(d))
        {
            v[d] = 1;
            return;
        }

        for(int j : graph.get(i))
        {
            dfs(n, j, graph, v);
        }
    }
}