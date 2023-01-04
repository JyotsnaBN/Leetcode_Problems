class Solution 
{
    public int minimumRounds(int[] tasks) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<tasks.length; i++)
        {
            if(map.containsKey(tasks[i]))
                map.put(tasks[i], map.get(tasks[i])+1);
            else
                map.put(tasks[i], 1);
        }
        int c = 0;
        for (Map.Entry ele : map.entrySet()) 
        {
            int key = (int)ele.getKey();
            int value = (int)ele.getValue();
            if(value<=1)
            {
                c = -1;
                break;
            }
            if(value<=3)
                c+=1;
            else
                c+=(value+2)/3;
            
        }
        return c;
    }
}