class Solution 
{
    char res[][] = new char[9][9];
    public void solveSudoku(char[][] board) 
    {
        HashMap<Integer, Set<Character>> rows = new HashMap<>();//row number mapped to numbers in that row
        HashMap<Integer, Set<Character>> cols = new HashMap<>();//col number mapped to numbers in that col
        HashMap<Integer, Set<Character>> box = new HashMap<>();//box number mapped to numbers in that box
        
        
        
        for(int i = 0; i<9; i++)
        {
            rows.put(i, new HashSet<Character> ());
            cols.put(i, new HashSet<Character> ());
            box.put(i, new HashSet<Character> ());
            
        }
        for(int i = 0; i<9; i++)
        {
            for(int j = 0; j<9; j++)
            {
                if(board[i][j] == '.')
                    continue;
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                int t = 0;
                t = (i<=2) ? 0 : (i<=5 ? 3 : 6);
                t+= (j<=2) ? 0 : (j<=5 ? 1 : 2);
                //System.out.println(i + " " + j + " " + t);
                box.get(t).add(board[i][j]);
            }
        }
        
        
        func(board, 0, 0, rows, cols, box);
        for(int i = 0; i<9; i++)
            for(int j = 0; j<9; j++)
                board[i][j] = res[i][j];

    }
    
    public void func(char board[][], int row, int col, HashMap<Integer, Set<Character>> rows, HashMap<Integer, Set<Character>> cols, HashMap<Integer, Set<Character>> box)
    {
        //System.out.println(row + " " + col);
        if(row == 9)
        {
            for(int i = 0; i<9; i++)
            {    
                for(int j = 0; j<9; j++)
                {    
                    //System.out.print(board[i][j] + " ");
                    res[i][j] = board[i][j];
                }
            }
            
            return;
        }

        
        
            if(board[row][col] != '.')
            {
                if(col==8)
                    func(board, row+1, 0, rows, cols, box);
                    
                else
                    func(board, row, col+1, rows, cols, box);
                
                
                return;
            }
            for(char j = '1'; j<='9'; j++)
            {
                int t = 0;
                t = (row<=2) ? 0 : (row<=5 ? 3 : 6);
                t+= (col<=2) ? 0 : (col<=5 ? 1 : 2);
                if(!rows.get(row).contains(j) && !cols.get(col).contains(j) && !box.get(t).contains(j))
                {
                    board[row][col] = j;
                    rows.get(row).add(j);
                    cols.get(col).add(j);
                    box.get(t).add(j);
                    
                    if(col==8)
                        func(board, row+1, 0, rows, cols, box);
                    
                    else
                        func(board, row, col+1, rows, cols, box);
                    
                    board[row][col] = '.';
                    rows.get(row).remove(j);
                    cols.get(col).remove(j);
                    box.get(t).remove(j);
                    
                    
                }
            }
    }
    
    
    
}