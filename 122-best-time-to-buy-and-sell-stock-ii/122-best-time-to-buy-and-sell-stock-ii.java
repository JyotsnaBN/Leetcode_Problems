class Solution 
{
    public int maxProfit(int[] arr) 
    {
        int n = arr.length;
        if(n==1)
            return 0;
        int sum = 0;
        int min = arr[0], max = 0, flag = 0;
        for(int i = 1; i<n; i++)
        {
            if(flag == 0 && arr[i]<min)
            {    
                min = arr[i];
            }
            else if(flag == 0)
            {
                max = arr[i];
                flag = 1;
            }
            else if(flag == 1 && arr[i]>max)
            {
                max = arr[i];  
            }
            else if(flag == 1)
            {
                sum+=max - min;
                flag = 0;
                min = arr[i];
                max = arr[i];
            }
        }
        if(flag == 1)
            sum+=max-min;
        return sum;
    }
}