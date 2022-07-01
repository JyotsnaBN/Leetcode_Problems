class Solution 
{
    public int maximumUnits(int[][] box, int size) 
    {
        int n = box.length;
        sort(box,1);
        int res = 0;
        for(int i = 0; i<n; i++)
        {
            //System.out.println(box[i][0] + "  " + box[i][1]);
            if(size<=box[i][0])
            {
                res+=size*box[i][1];
                break;
            }
            res+=box[i][0]*box[i][1];
            size-=box[i][0];
        }
        return res;
        
    }
    public static void sort(int arr[][], int col)
    {
        Arrays.sort(arr, new Comparator<int[]>() {
            
            @Override              
            public int compare(final int[] entry1, final int[] entry2) 
            {
                if (entry1[col] <= entry2[col])
                    return 1;
                else
                    return -1;
            }
        });
    }
}