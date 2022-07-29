class Solution 
{
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) 
    {
        if(n==1 && headID == 0)
            return 0;
        
        Map<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        
        for(int i = 0; i<n; i++)
        {
            if(manager[i] == -1)
                continue;
            graph.computeIfAbsent(manager[i] , k -> new ArrayList<>() ).add(i);
        }
        
        return dfs(graph, headID, informTime);
        
    }
    public int dfs(Map<Integer, ArrayList<Integer>> graph, int h, int informTime[])
    {
        int res = 0;
        if(!graph.containsKey(h))
            return 0;
        for(int i : graph.get(h))
        {
            res = Math.max(dfs(graph, i, informTime), res);
            
        }
        return res + informTime[h];
    }
}