class Solution 
{
    public int minRefuelStops(int target, int fuel, int[][] arr) 
    {
        int res = 0, n = arr.length;
        if(fuel >= target)
            return res;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((s1, s2) -> {
            return s2[1] - s1[1];
        });
        
        int i = 0;
        while(fuel<target)
        {
            for(; i<n; i++)
            {
                if(arr[i][0]>fuel)
                {    
                    break;
                }
                pq.add(arr[i]);
                
            }
            if(pq.size() == 0)
                return -1;
            fuel+= (pq.poll())[1];
            res++;
 
        }

        return res;
        
    }
}