class Solution 
{
    List<String> res;
    int m, n;
    public List<String> findWords(char[][] board, String[] words) 
    {
        Trie trie = new Trie();
        
        for(String s : words)
            trie.insert(s);
        
        res = new ArrayList<String>();
        m = board.length;
        n = board[0].length;
        boolean vis[][] = new boolean[m][n];
        
        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
                func(board, vis, trie, i, j, "");
        
        return res;
    }
    public void func(char board[][], boolean vis[][], Trie trie, int i, int j, String s)
    {
        if(i<0 || i>=m || j<0 || j>=n || vis[i][j])
            return;
        
        
        if(trie.map.containsKey(board[i][j]))
        {
            s += board[i][j];
            trie = trie.map.get(board[i][j]);
            //System.out.println(i + " " + j + " " + s + " " + trie.w);

            if(!trie.w.equals(""))
            {
                //System.out.println();
                res.add(trie.w);
                trie.w = "";
            }
            
            vis[i][j] = true;
            
            func(board, vis, trie, i+1, j, s);
            func(board, vis, trie, i-1, j, s);
            func(board, vis, trie, i, j+1, s);
            func(board, vis, trie, i, j-1, s);
            
            vis[i][j] = false;
        }
    }
}

class Trie
{
    HashMap<Character, Trie> map;
    String w;
    
    Trie()
    {
        map = new HashMap<Character, Trie>();
        w = "";
    }
    
    public void insert(String word)
    {
        Trie curr = this;
        
        for(int i = 0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            if(!curr.map.containsKey(c))
                curr.map.put(c, new Trie());
            curr = curr.map.get(c);
        }
        curr.w = word;        
    }
}