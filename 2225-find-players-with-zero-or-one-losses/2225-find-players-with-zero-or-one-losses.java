class Solution 
{
    public List<List<Integer>> findWinners(int[][] matches) 
    {
        int n = matches.length, k = 0;
        HashMap<Integer, Integer> win = new HashMap<> ();
        HashMap<Integer, Integer> lose = new HashMap<> ();
        Set<Integer> set = new HashSet<> ();
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        List<Integer> res1 = new ArrayList<Integer>();
        List<Integer> res2 = new ArrayList<Integer>();
        for(int i = 0; i<n; i++)
        {
            int a = matches[i][0];
            int b = matches[i][1];
            set.add(a);
            set.add(b);
            if(win.containsKey(a))
                win.put(a, win.get(a)+1);
            else
                win.put(a, 1);
            
            if(lose.containsKey(b))
                lose.put(b, lose.get(b)+1);
            else
                lose.put(b, 1);
        }
 
        
        for(Integer value:set)
        {
            if(win.containsKey(value) && win.get(value)>=1 && (!lose.containsKey(value) || lose.get(value)==0))
                res1.add(value);
            if((!win.containsKey(value) || win.get(value)>=0) && (lose.containsKey(value) && lose.get(value)==1))
                res2.add(value);
        }
        Collections.sort(res1);
        Collections.sort(res2);
        res.add(res1);
        res.add(res2);
        
        return res;
        
    }
}