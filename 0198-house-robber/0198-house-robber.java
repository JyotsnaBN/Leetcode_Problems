class Solution {
    public int rob(int[] nums) 
    {
        int n = nums.length;

        if(n==0)
            return 0;
        if(n==1)
            return nums[0];

        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        int c;
        
        int res = Math.max(a, b);
        
        for(int i = 2; i<n; i++)
        {
            c = Math.max (  (a+nums[i]) , (b)  );
            res = c>res ? c : res;
            
            a = b;
            b = c;
        }
        return res;
    }
}