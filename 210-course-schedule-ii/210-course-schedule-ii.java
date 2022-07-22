class Solution 
{
    int n;
    public int[] findOrder(int num, int[][] pre) 
    {
        n = num;
        int arr[][] = new int[n][n];
        int v[] = new int[n];
        int res[] = new int[n];
        
        for(int i = 0; i<pre.length; i++)
        {
            int a = pre[i][0];
            int b = pre[i][1];
            arr[a][b] = 1;
        }
        
        if(hasCycle(arr))
        {    
            //System.out.println("Cycle");
            return new int[0];
        }
        
        
        
        Stack<Integer> s = new Stack<Integer> ();
        Arrays.fill(v, 0);
        for(int i = 0; i<n; i++)
        {
            if(v[i]==0)
                topoSort(i, arr, v, s); 
        }
        int j = n-1;
        while(!s.isEmpty())
            res[j--] = s.pop();
        
        return res;
        
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
        //System.out.println("Push - " + i);
    }
    
    
    
    
    public boolean hasCycle(int arr[][])
    {
        int v[] = new int[n];
        int dv[] = new int[n];
        for(int i = 0; i<n; i++)
        {
            if(v[i]==0)
            {
                if(func(i, arr, v, dv))
                    return true;
            }
            
        }
        return false;
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
                if(func(j, arr, v, dv))
                    return true;
            }
            else if(dv[j] == 1)
                return true;
        }
        dv[i] = 0;
        return false;
    }
}