class Solution 
{
    public long taskSchedulerII(int[] tasks, int k) 
    {
        int n = tasks.length;
        if(n==1)
            return 1;
        long res = 0;
        HashMap<Integer, Long> map = new HashMap<>();
        int t;
        long val;
        for(int i = 0; i<n; i++)
        {
            t = tasks[i];
            if(map.containsKey(t))
            {
                val = map.get(t);
                if(val<res)
                {  
                    res++;
                    map.put(t, res+k);
                    //System.out.println(t + "  " + map.get(t));
                }
                else
                {
                    res+= (val - res);
                    res++;
                    map.put(t, res + k);
                    //System.out.println(t + "  " + map.get(t));
                }
            }
            else
            {
                res++;
                map.put(t, res+k);
                //System.out.println(t + "  " + map.get(t));
                
            }
            //System.out.println(res);
        }
        
        return res;
        
    }
}