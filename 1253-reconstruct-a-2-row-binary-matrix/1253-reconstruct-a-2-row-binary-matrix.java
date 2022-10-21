class Solution 
{
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) 
    {
        List<List<Integer>> res = new ArrayList<>();
        
        List l1 = new ArrayList<Integer>();
        List l2 = new ArrayList<Integer>();
        
        int m = colsum.length;
        int mat[][] = new int[2][m];
        
        int flag = 0;
        for(int i = 0; i<m; i++)
        {
            if((colsum[i] == 2) && (upper<=0 || lower<=0))
                return res;
            if(colsum[i] == 2)
            {
                mat[0][i] = 1;
                mat[1][i] = 1;
                upper --;
                lower --;
            }
            else if(colsum[i] == 0)
            {
                mat[0][i] = -1;
                mat[1][i] = -1;
            }
            else
                flag++;
                
        }
        if(flag != upper+lower)
        {
            return res;
        }
        
               
        for(int i = 0; i<m; i++)
        {
            if(colsum[i]==1 && upper>0)
            {    
                mat[0][i] = 1;
                upper--;
                colsum[i]--;
            } 
            else if(mat[0][i] == -1)
                mat[0][i] = 0;
            
            l1.add(mat[0][i]);
        }
        for(int i = 0; i<m; i++)
        {
            if(colsum[i]==1 && lower>0)
            {    
                mat[1][i] = 1;
                lower--;
            } 
            else if(mat[1][i] == -1)
                mat[1][i] = 0;
            l2.add(mat[1][i]);
        }
        
        
        
        res.add(l1);
        res.add(l2);
        
        return res;
    }
}