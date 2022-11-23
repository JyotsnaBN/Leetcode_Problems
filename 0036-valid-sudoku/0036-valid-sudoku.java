class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
        HashSet<Character> set = new HashSet<Character> ();
        for(int i = 0; i<9; i++)
        {
            for(int j = 0; j<9; j++)
            {
                if(set.contains(board[i][j]) && board[i][j] != '.')
                    return false;
                else if(board[i][j]!='.')
                    set.add(board[i][j]);
            }
            set.clear();
        }
        for(int i = 0; i<9; i++)
        {
            for(int j = 0; j<9; j++)
            {
                if(set.contains(board[j][i]) && board[j][i] != '.')
                    return false;
                else if(board[j][i]!='.')
                    set.add(board[j][i]);
            }
            set.clear();
        }
        HashSet<Character> set1 = new HashSet<Character> ();
        HashSet<Character> set2 = new HashSet<Character> ();
        HashSet<Character> set3 = new HashSet<Character> ();
        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                if(set1.contains(board[i][j]) && board[i][j] != '.')
                    return false;
                else if(board[i][j]!='.')
                    set1.add(board[i][j]);
            }
            
            for(int j = 3; j<6; j++)
            {
                if(set2.contains(board[i][j]) && board[i][j] != '.')
                    return false;
                else if(board[i][j]!='.')
                    set2.add(board[i][j]);
            }

            for(int j = 6; j<9; j++)
            {
                if(set3.contains(board[i][j]) && board[i][j] != '.')
                    return false;
                else if(board[i][j]!='.')
                    set3.add(board[i][j]);
            }
   
        }
        
        set1.clear();
        set2.clear();
        set3.clear();
        
        
        
        for(int i = 3; i<6; i++)
        {
            for(int j = 0; j<3; j++)
            {
                if(set1.contains(board[i][j]) && board[i][j] != '.')
                    return false;
                else if(board[i][j]!='.')
                    set1.add(board[i][j]);
            }
            
            for(int j = 3; j<6; j++)
            {
                if(set2.contains(board[i][j]) && board[i][j] != '.')
                    return false;
                else if(board[i][j]!='.')
                    set2.add(board[i][j]);
            }

            for(int j = 6; j<9; j++)
            {
                if(set3.contains(board[i][j]) && board[i][j] != '.')
                    return false;
                else if(board[i][j]!='.')
                    set3.add(board[i][j]);
            }
        }
        
        
        set1.clear();
        set2.clear();
        set3.clear();
        
        
        
        for(int i = 6; i<9; i++)
        {
            for(int j = 0; j<3; j++)
            {
                if(set1.contains(board[i][j]) && board[i][j] != '.')
                    return false;
                else if(board[i][j]!='.')
                    set1.add(board[i][j]);
            }
            
            for(int j = 3; j<6; j++)
            {
                if(set2.contains(board[i][j]) && board[i][j] != '.')
                    return false;
                else if(board[i][j]!='.')
                    set2.add(board[i][j]);
            }

            for(int j = 6; j<9; j++)
            {
                if(set3.contains(board[i][j]) && board[i][j] != '.')
                    return false;
                else if(board[i][j]!='.')
                    set3.add(board[i][j]);
            }
        }
        return true;
        
    }
}