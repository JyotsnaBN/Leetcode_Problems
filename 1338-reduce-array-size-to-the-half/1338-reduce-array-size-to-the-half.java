class Solution 
{
    public int minSetSize(int[] arr) 
    {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++)
        {
            if(map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }
        int a[] = new int[map.size()];
        int j = 0;
        for(Map.Entry<Integer, Integer> i : map.entrySet())
        {
            a[j++] = i.getValue();
        }
        Arrays.sort(a);
        
        int sum = 0, res = 0;
        n=n/2;
        for(int i = a.length - 1; i>=0; i--)
        {
            sum+=a[i];
            res++;
            if(sum>=n)
                return res;
        }
        return res;
    }
}
