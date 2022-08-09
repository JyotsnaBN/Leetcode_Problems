class Solution 
{
    int res = 0;
    public int totalNQueens(int n) 
    {
        char arr[][] = new char[n][n];
        
        for(int i = 0; i<n; i++)
            Arrays.fill(arr[i], '.');
        
        Set<Integer> row = new HashSet<Integer>();
        Set<Integer> d1 = new HashSet<Integer>();
        Set<Integer> d2 = new HashSet<Integer>();
        
        func(0, n, arr, row, d1, d2);
        
        return res;
    }
    
    public void func(int col, int n, char arr[][], Set<Integer> row, Set<Integer> d1, Set<Integer> d2)
    {
        if(col==n)
        {
            res++;
            return;
        }
        
        for(int i = 0; i<n; i++)
        {
            if(!row.contains(i) && !d1.contains(i+col) && !d2.contains(i-col))
            {
                arr[i][col] = 'Q';
                row.add(i);
                d1.add(i+col);
                d2.add(i-col);
                
                func(col+1, n, arr, row, d1, d2);
                
                arr[i][col] = '.';
                row.remove(i);
                d1.remove(i+col);
                d2.remove(i-col);
            }
        }   
        
    }
}
