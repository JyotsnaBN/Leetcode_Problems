class Solution 
{
    public int maximumBags(int[] cap, int[] rocks, int k) 
    {
        int n = cap.length;
        int arr[] = new int[n];
        int count = 0;
        for(int i = 0; i<n; i++)
        {
            arr[i] = cap[i]-rocks[i];
            if (arr[i]==0)
                count++;
        }
        
        Arrays.sort(arr);
        for(int i = count; i<n; i++)
        {
            if(k==0)
                break;
            if(k>=arr[i])
            {
                k-=arr[i];
                arr[i] = 0;
                count++;
            }
            else if(k<arr[i])
                break;
        }
        
        return count;
    }
    
    
}