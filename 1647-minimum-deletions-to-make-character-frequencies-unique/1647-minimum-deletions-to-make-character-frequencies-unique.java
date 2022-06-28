class Solution 
{
    public int minDeletions(String s) 
    {
        int n = s.length();
        int arr[] = new int[26];
        int index = 0;
        
        for(int i = 0; i<n; i++)
        {
            index = (int)(s.charAt(i) - 'a');
            arr[index]++;
        }
        
        Arrays.sort(arr);
        boolean flag = false;
        
        HashSet<Integer> set = new HashSet<Integer> ();
        int res = 0;
        
        for(int i = 25; i>=0; i--)
        {
            if(arr[i]==0)
                break;
            while(set.contains(arr[i]))
            {
                arr[i]--;
                res++;
                if(arr[i] == 0)
                    break;
            }
            set.add(arr[i]);
        }
        
        return res;
    }
}