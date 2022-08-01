class Solution 
{
    public int maximumGroups(int[] grades) 
    {
        int n = grades.length;
        int res = 0;
        int sum = 0;
        int i = 2;
        while(sum<n)
        {
            sum+=i;
            i++;
            res++;
        }
        return res;
    }
}