class Solution 
{
    public boolean isToeplitzMatrix(int[][] mat) 
    {
        int m = mat.length, n = mat[0].length;
        
        for(int i = 0; i<n; i++)
        {
            int x = mat[0][i];
            int y = 0, z = i;
            
            while(y<m && z<n)
            {
                //System.out.print(y + " " + z + "       ");
                if(mat[y][z] != x)
                    return false;
                
                y++;
                z++;
            }  
        }
        
        
        for(int i = 1; i<m; i++)
        {
            int x = mat[i][0];
            int y = i, z = 0;
            
            while(y<m && z<n)
            {
                //System.out.print(y + " " + z + "       ");
                if(mat[y][z] != x)
                    return false;
                
                y++;
                z++;
            }  
        }
        
        return true;
        
    }
}