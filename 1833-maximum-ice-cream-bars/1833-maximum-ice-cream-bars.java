class Solution 
{
    public int maxIceCream(int[] costs, int coins) 
    {
        Arrays.sort(costs);
        
        int sum = 0;      
        int res = 0;
        
        for(int i : costs)
        {
            if(i + sum <= coins)
            {    
                sum += i;
                res++;
            }
            else
                break;
        }
        
        return res;
    }
}