class Solution 
{
    public int findJudge(int n, int[][] trust) 
    {
        if(n==1)
            return 1;
        int mat[][] = new int[n+1][n+1];
        List<Integer> res = new ArrayList<Integer> ();
        for(int i = 0; i<trust.length; i++)
        {
            int a = trust[i][0] - 1;
            int b = trust[i][1] - 1;
            mat[a][b] = 1;
            mat[a][n] +=1;
            mat[n][b] +=1;
            if(mat[n][b] == n-1)
                res.add(b);
        }
        /*for(int i = 0; i<=n; i++)
        {
            for(int j = 0; j<=n; j++)
                System.out.print(mat[i][j] + "  ");
            System.out.println();
        }*/
        
        
        if(res.size() != 1)
            return -1;
        int result = res.get(0);
        if(mat[result][n] == 0)
            return result+1;
        return -1;
        
    }
}