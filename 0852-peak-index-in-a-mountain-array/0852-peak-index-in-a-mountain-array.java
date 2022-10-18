class Solution 
{
    public int peakIndexInMountainArray(int[] arr) 
    {
        int n = arr.length;
        int s = 0, e = n-1, mid = (s+e)/2;
        
        while(s<=e)
        {
            mid = (s+e)/2;
            //System.out.println(mid);
            if(mid <= 0)
                mid = 1;
            if(mid >= n-1)
                mid = n-2;
            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1])
                return mid;
            else if(arr[mid - 1]>arr[mid])
                e = mid - 1;
            else
                s = mid + 1;
        }
        //System.out.println();
        return -1;
    }
}