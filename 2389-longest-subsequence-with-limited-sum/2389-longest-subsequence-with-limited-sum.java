class Solution 
{
    public int[] answerQueries(int[] nums, int[] q) 
    {
        Arrays.sort(nums);
        int m = q.length, n = nums.length;
        int res[] = new int[m];
        
        for(int i = 1; i<n; i++)
        {
            nums[i] += nums[i-1];
        }
        int curr = 0;
        
        for(int i = 0; i<m; i++)
        {
            curr = q[i];
            if(curr<nums[0])
            {
                res[i] = 0;
                continue;
            }
            
            for(int j = 0; j<n; j++)
            {
                if(curr<nums[j])
                    break;
                res[i] = j+1;
            }
            
        }
        
        return res;
    }
}