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











