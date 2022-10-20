class Solution 
{
    public List<List<Integer>> fourSum(int[] arr, int target) 
    {
        SortedSet<Element> set = new TreeSet<Element>(new EleComp());
        Set<List<Integer>> res = new HashSet<List<Integer>> ();
        int n = arr.length;
        
        int nums[] = new int[n];
        Arrays.sort(arr);
        int j = 0;
        int co = 0, val = arr[0];
        for(int i = 0; i<n; i++)
        {
            if(arr[i] == val)
            {    
                co++;
            }
            else
            {
                co = 1;
                val = arr[i];
            }
            if(co<=4)
            {
                nums[j++] = arr[i];
            }
                
            
        }
        n = j;
        
        
        
        
        for(int i = 0; i<n; i++)
        {
            for(j = i + 1; j<n; j++)
            {
                long temp = (long)nums[i] + (long)nums[j];
                if(temp>Integer.MAX_VALUE || temp<Integer.MIN_VALUE)
                    continue;
                set.add(new Element(i, j , nums[i] + nums[j]));
            }
        }
        
        LinkedHashMap<Integer, ArrayList<Element>> map = new LinkedHashMap<Integer, ArrayList<Element>>();
        ArrayList<Element> list = new ArrayList<Element>();
        //z of 1st ele -- val
        boolean f = true;
        val = 0;
        for(Element i : set)
        {   
            if(f)
            {
                f = false;
                val = i.z;
            }
            if(i.z == val)
            {
                list.add(i);
            }
            else
            {
                map.put(val, list);
                //System.out.println(val + " " + list);
                list = new ArrayList<Element>();
                list.add(i);
                val = i.z;
            }
        }
        map.put(val, list);
        //System.out.println(val + " " + list);
        
        List<Element> l1 = new ArrayList<Element>();
        List<Element> l2 = new ArrayList<Element>();
        
        
        List<Integer> listKeys = new ArrayList<Integer>(map.keySet());

        int len = map.size();
        int i = 0;
        j = len - 1;
        while(i<len && j>=0 && i<=j)
        {
            int x = listKeys.get(i), y = listKeys.get(j);
            
            long temp = (long)x + (long)y;

            if(temp<Integer.MAX_VALUE && temp>Integer.MIN_VALUE && x+y==target)
            {
                l1 = new ArrayList<Element>();
                l2 = new ArrayList<Element>();
                l1 = map.get(x);
                l2 = map.get(y);
                //System.out.println(x + " " + y + " " + l1 + " " + l2);
                
                for(int p = 0; p<l1.size(); p++)
                {
                    for(int q = 0; q<l2.size(); q++)
                    {
                        int a = l1.get(p).x, b = l1.get(p).y;
                        int c = l2.get(q).x, d = l2.get(q).y;
                        
                        
                        if(a!=c && a!=d && b!=c && b!=d) 
                        {
                            List<Integer> l = new ArrayList<Integer> ();
                            l.add(nums[a]);
                            l.add(nums[b]);
                            l.add(nums[c]);
                            l.add(nums[d]);
                            Collections.sort(l);

                            res.add(l);
                        }
                        
                    }
                }
                
                i++;
                j--;
            }
            else if(temp>Integer.MAX_VALUE || x+y>target)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        
        
        
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        for(List<Integer> k : res)
            result.add(k);
        
        return result;     
    }
}
class Element
{
    int x, y, z;
    Element(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
class EleComp implements Comparator<Element> 
{
    public int compare(Element e1, Element e2)
    {
        if(e1.z>e2.z)
            return 1;
        else if(e1.z<e2.z)
            return -1;
        else
        {
            if(e1.x>e2.x)
                return 1;
            else if(e1.x<e2.x)
                return -1;
            else
            {
                if(e1.y>e2.y)
                    return 1;
                else if(e1.y<e2.y)
                    return -1;
            }
            
        }
        return 0;
    }
}


/*
//O(n^3) solution
class Solution 
{
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        Set<List<Integer>> res = new HashSet<List<Integer>> ();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i<n; i++)
        {
            for(int j = i+1; j<n; j++)
            {
                int l = j+1, r = n-1;
                while(l<r)
                {
                    long temp = (long)nums[i]+nums[j]+nums[l]+nums[r];
                    //System.out.println(nums[i] + " " + nums[j] + " " +nums[l] + " " +nums[r] + " " + temp);
                    if(temp<target)
                        l++;
                    else if(temp>target)
                        r--;
                    else
                    {
                        List<Integer> list = new ArrayList<Integer> ();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        Collections.sort(list);
                        
                        res.add(list);
                        
                        l++;
                    }
                }     
                
                
            }
            //System.out.println();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        for(List<Integer> i : res)
            result.add(i);
        
        return result;
    }
}
*/








/*
//O(n^4) solution

class Solution 
{
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        Set<List<Integer>> res = new HashSet<List<Integer>> ();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i<n; i++)
        {
            for(int j = i+1; j<n; j++)
            {
                for(int k = j+1; k<n; k++)
                {
                    for(int l = k+1; l<n; l++)
                    {
                        if((long)nums[i]+nums[j]+nums[k]+nums[l] != target)
                            continue;
                        List<Integer> list = new ArrayList<Integer> ();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        Collections.sort(list);
                        
                        res.add(list);
                        break;
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        for(List<Integer> i : res)
            result.add(i);
        
        return result;
    }
}




*/











