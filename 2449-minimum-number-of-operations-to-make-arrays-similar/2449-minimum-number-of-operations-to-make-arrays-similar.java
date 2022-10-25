class Solution 
{
    public long makeSimilar(int[] nums, int[] target) 
    {
        int n = nums.length;
        if(n == 1)
            return 0;
        if(n == 2)
        {
            
        }
        Arrays.sort(nums);
        Arrays.sort(target);
        List<Integer> e = new ArrayList<Integer>();
        List<Integer> o = new ArrayList<Integer>();
        for(int i : nums)
        {
            if(i%2==0)
                e.add(i);
            else
                o.add(i);
        }
        int arr[] = new int[n];
        
        int i = 0, j = 0;
        for(i = 0; i<e.size(); i++)
        {
            arr[i] = e.get(i);
        }
        for(j = 0; j<o.size(); j++)
        {
            arr[i++] = o.get(j);
        }
        
        e = new ArrayList<Integer>();
        o = new ArrayList<Integer>();
        for(int k : target)
        {
            if(k%2==0)
                e.add(k);
            else
                o.add(k);
        }
        long sum = 0;
        for(i = 0; i<e.size(); i++)
        {
            arr[i] = e.get(i) - arr[i];
            
            if(arr[i]>0)
                sum+=arr[i];
        }
        for(j = 0; j<o.size(); j++)
        {
            arr[i] = o.get(j) - arr[i];
            if(arr[i]>0)
                sum+=arr[i];
            i++;
        }
        
        //System.out.println(arr);
        //for(i = 0; i<n; i++)
        //{
           // System.out.print(arr[i] + "  ");
        //}
        //System.out.println();
        
        
        
        
        
        
        
        
        
        return sum/2;
        
    }
}