class Solution 
{
    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] arr) 
    {
        m = arr.length;
        n = arr[0].length;
        char a[][] = new char[m][n], b[][] = new char[m][n];
        List<List<Integer>> res = new ArrayList<>();
        
        
        for(int i = 0; i<m; i++)
        {
            Arrays.fill(a[i], 'a');
            Arrays.fill(b[i], 'a');
        }
        
        for(int i = 0; i<m; i++)
        {
            a[i][0] = 'b';
            b[i][n-1] = 'b';
        }
        for(int i = 0; i<n; i++)
        {
            a[0][i] = 'b';
            b[m-1][i] = 'b';
        }
        
        
        for(int i = 0; i<m; i++)
        {
            func(i, 0, arr, a, arr[i][0], false);
            func(i, n-1, arr, b, arr[i][n-1], false);
        }
        for(int i = 0; i<n; i++)
        {
            func(0, i, arr, a, arr[0][i], false);
            func(m-1, i, arr, b, arr[m-1][i], false);
        }
        
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(a[i][j] == 'b' && b[i][j] == 'b')
                {
                    List<Integer> temp = new ArrayList<> ();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
        
    }
    
    public void func(int i, int j, int arr[][], char a[][], int val, boolean flag)
    {
        //System.out.println(i + " " + j);
        if(i<0 || j<0 || i>=m || j>=n || arr[i][j]<val)
            return;
        
        if(a[i][j] == 'b' && flag)
            return;
        
        a[i][j] = 'b';
        
        
        
        func(i+1, j, arr, a, arr[i][j], true);
        func(i-1, j, arr, a, arr[i][j], true);
        func(i, j+1, arr, a, arr[i][j], true);
        func(i, j-1, arr, a, arr[i][j], true);
        
        
    }
}