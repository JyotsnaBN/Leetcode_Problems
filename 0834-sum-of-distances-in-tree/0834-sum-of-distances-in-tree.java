class Solution 
{
    public int[] sumOfDistancesInTree(int n, int[][] edges) 
    {     
        if(n < 2 || edges == null) 
            return new int[]{0};
        
        int count[] = new int[n];
        Arrays.fill(count, 1);
        int distances[] = new int[n];
        Map<Integer, List<Integer>> graph = getGraph(edges);
        post(0, -1, count, distances, graph);
        pre(0, -1, count, distances, graph, n);
        return distances;
    }
    
    
    public Map<Integer, List<Integer>> getGraph(int[][] edges) 
    {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge: edges) 
        {
            graph.putIfAbsent(edge[0], new LinkedList<>());
            graph.putIfAbsent(edge[1], new LinkedList<>());
            
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);       
        }
        
        return graph;
    }
    
    
    public void post(int node, int parent, int[] count, int[] distances, Map<Integer, List<Integer>> graph) 
    {
        List<Integer> children = graph.get(node);
        for(int child: children) 
        {
            if(child != parent) 
            {
                post(child, node, count, distances, graph);
                count[node] += count[child];
                distances[node] += distances[child] + count[child];
            }
        }
    }
    
    public void pre(int node, int parent, int[] count, int[] distances, Map<Integer, List<Integer>> graph, int n) 
    {
        List<Integer> children = graph.get(node);
        for(int child: children) 
        {
            if(child != parent) 
            {
				distances[child] = distances[node] + (n - count[child]) - count[child];
				pre(child, node, count, distances, graph, n);            
            }
        }
    }
}