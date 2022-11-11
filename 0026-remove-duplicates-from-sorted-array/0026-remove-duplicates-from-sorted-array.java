class Solution 
{
    public int removeDuplicates(int[] nums) 
    {
        int k = nums.length;
        int curr = nums[0];
        for(int i = 1; i<k; i++)
        {
            if(nums[i]==curr)
            {
                for(int j = i; j<k-1; j++)
                    nums[j] = nums[j+1];
                k--;
                i--;
            }
            else
                curr = nums[i];
        }
        return k;
    }
}