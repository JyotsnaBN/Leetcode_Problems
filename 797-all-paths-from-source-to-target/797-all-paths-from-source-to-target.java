class Solution 
{
    int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) 
    {
        n = graph.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> t = new ArrayList<Integer> ();
        t.add(0);
        dfs(t, graph, res, 0);
        return res;
        
    }
    public void dfs(List<Integer> t, int graph[][], List<List<Integer>> res, int i)
    {
        if(i == n-1)// If we reach the last node, add that path to the result and return
        {
            res.add(new ArrayList<>(t));
            return;
        }
        
        for(int j : graph[i])// Otherwise, traverse adjacent nodes 
        {
            t.add(j);// Add it to the list
            dfs(t, graph, res, j);
            t.remove(t.size() - 1);// Remove the last node from the list
        }
    }
}