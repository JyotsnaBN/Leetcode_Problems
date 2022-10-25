class Solution 
{
    public long makeSimilar(int[] nums, int[] target) 
    {
        int n = nums.length;
        int i = 0, j = 0;
        if(n == 1)
            return 0;

        Arrays.sort(nums);
        Arrays.sort(target);
        
        
        int arr[] = new int[n];
        
        for(int k : nums)
        {
            if(k%2==0)
                arr[i++] = k;
        }
        for(int k : nums)
        {
            if(k%2!=0)
                arr[i++] = k;
        }
        
        i = 0;
        long sum = 0;
        for(int k : target)
        {
            if(k%2==0)
            {    
                arr[i] = k - arr[i];
                if(arr[i]>0)
                    sum += arr[i];
                i++;
            }
        }
        for(int k : target)
        {
            if(k%2!=0)
            {    
                arr[i] = k - arr[i];
                if(arr[i]>0)
                    sum += arr[i];
                i++;
            }
        }

        
        return sum/2;
        
    }
}