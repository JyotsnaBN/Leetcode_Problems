class Solution 
{
    public int maxArea(int[] arr) 
    {
        int max = 0, curr = 0;
        int n = arr.length, l = 0, r = n-1;
        max = (r-l)*Math.min(arr[l],arr[r]);
        while(l<r)
        {
            if(arr[l]<arr[r])
                l++;
            else
                r--;
            curr = (r-l)*Math.min(arr[l],arr[r]);
            if(curr>max)
                max = curr;
            
        }
        return max;
    }
}