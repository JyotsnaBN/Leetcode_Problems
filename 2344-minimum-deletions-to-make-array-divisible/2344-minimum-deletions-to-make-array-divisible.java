class Solution 
{
    public int minOperations(int[] nums, int[] nD) 
    {
        int n = nums.length, m = nD.length, t = 0, gcd = nD[0], n1 = nD[0];
        Arrays.sort(nums);
        for(int i = 1; i<m; i++)
        {
            int n2 = nD[i];
            while(n2>0)
            {
                t = n2;
                n2 = n1%n2;
                n1 = t;
            }
            gcd = n1;
        }
        for(int i = 0; i<n; i++)
        {
            if(nums[i]>gcd)
                break;
            if(gcd%nums[i] == 0)
                return i;
        }
        return -1;
    }
}