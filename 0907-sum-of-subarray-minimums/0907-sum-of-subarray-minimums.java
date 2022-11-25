class Solution 
{
    int n;
    public int sumSubarrayMins(int[] arr) 
    {
        n = arr.length;
        long M = 1000000007;
        int res = 0;
        Stack<Pair<Integer, Integer>> s = new Stack<>();
        
        s.push(new Pair(0,-1));
        
        
        int temp1[] = new int[n];
        int temp2[] = new int[n];

        
        int ind = 0;
        
        for(int i = 0; i<n; i++)
        {
   
                while(s.peek().getKey()>=arr[i])
                    s.pop();

            
            
            temp1[i] += (i - s.peek().getValue());
            s.push(new Pair(arr[i],i));
        }
        
        
        s.clear();
        s.push(new Pair(0, n));
        
        
        for(int i = n-1; i>=0; i--)
        {
    
                while(s.peek().getKey()>arr[i])
                    s.pop();  
               
            temp2[i] += (s.peek().getValue() - i);
            s.push(new Pair(arr[i],i));
        }
        
        for(int i = 0; i<n; i++)
        {
            long add = (long)(temp1[i] * temp2[i] * (long)arr[i]) % M;
            res += add ;
            res %= M;
        }
        

        return res;
            
    }
}