class Solution 
{
    int n;
    public List<List<Integer>> getAncestors(int no, int[][] edges) 
    {
        n = no;
        int arr[][] = new int[n][n];
        int v[] = new int[n];
        int res[] = new int[n];
        
        for(int i = 0; i<edges.length; i++)
        {
            int a = edges[i][0];
            int b = edges[i][1];
            arr[a][b] = 1;
        }
        
        Stack<Integer> s = new Stack<Integer> ();
        Arrays.fill(v, 0);
        for(int i = 0; i<n; i++)
        {
            if(v[i]==0)
                topoSort(i, arr, v, s); 
        }
        int j = 0;
        while(!s.isEmpty())
            res[j++] = s.pop();
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for(int i = 0; i<n; i++)
        {    
            result.add(new ArrayList<Integer> ());
            //System.out.print(res[i] + "  ");
        }
        
         //System.out.println();
    
        for(int i = 1; i<n; i++)
        {
            Set<Integer> temp = new HashSet<Integer> ();
            for(j = i-1; j>=0; j--)
            {
                //System.out.println(i + "   " + j + "   " + arr[  res[j] ]   [res[i]  ]);
                int t = res[j];
                if(arr[t]   [res[i]  ] == 1 )
                {    
                    temp.add(t);
                    temp.addAll(result.get(t));
                }
            }
            List<Integer> list = new ArrayList<Integer> (temp);
            Collections.sort(list);
            result.set(res[i], list);
        }
        return result;
        
    }
    public void topoSort(int i, int arr[][], int v[], Stack<Integer> s)
    {
        v[i] = 1;
        
        for(int j = 0; j<n; j++)
        {
            if(arr[i][j] == 1 && v[j] == 0)
            {
                topoSort(j, arr, v, s);
            }
        }
        s.push(i);
    }
}