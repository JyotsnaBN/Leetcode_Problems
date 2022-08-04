class Solution 
{
    public List<Integer> partitionLabels(String s) 
    {
        SortedSet<Gap> set = new TreeSet<Gap>(new GapComp ());
        int arr[][] = new int[2][26];
        int n = s.length();
        Arrays.fill(arr[0], -1);
        Arrays.fill(arr[1], -1);
        for(int i = 0; i<n; i++)
        {
            int t = (int)(s.charAt(i) - 'a');
            if(arr[0][t] == -1)
            {
                arr[0][t] = arr[1][t] = i;
            }
            else
            {
                arr[1][t] = i;
            }
        }
        for(int i = 0; i<26; i++)
        {
            if(arr[0][i]!=-1)
            {
                set.add(new Gap(arr[0][i], arr[1][i]));
                //System.out.println(arr[0][i] + " " + arr[1][i]);
            }
        }
        List<Integer> res = new ArrayList<>();
        if(set.size() == 1)
        {
            res.add(n);
            return res;
        }
        int c = 0;
        int pi = -1, pj = -1;
        //System.out.println();
        for(Gap e : set)
        {
            int i = e.i, j = e.j;
            //System.out.println(pi + " " + pj + " " + i + " " + j);
            if(c == 0)
            {
                pi = i;
                pj = j;
                c++;
                continue;
            }
            if(i<pj)
            {
                pj = Math.max(j, pj);
            }
            else
            {
                res.add(pj - pi + 1);
                pi = i;
                pj = j;
            }
            
            c++;
        }
        res.add(pj - pi + 1);
        
        return res;
        
        
        
        
    }
}
class Gap
{
    int i,j;
    Gap(int i, int j)
    {
        this.i = i;
        this.j = j;
    }
}
class GapComp implements Comparator<Gap>
{
    public int compare(Gap e1, Gap e2)
    {
        if(e1.i<e2.i)
            return -1;
        else if(e1.i>e2.i)
            return 1;
        else
            return 0;
    }
}