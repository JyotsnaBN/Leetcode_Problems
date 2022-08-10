class Solution 
{
    public int leastInterval(char[] tasks, int k) 
    {
        PriorityQueue<Element> pq = new PriorityQueue<Element>(new ElementComp());
        HashMap<Character, Integer> count = new HashMap<>();
        int n = tasks.length;
        for(int i = 0; i<n; i++)
        {
            char c = tasks[i];
            if(count.containsKey(c))
                count.put(c, count.get(c) + 1);
            else 
                count.put(c, 1);
        }
        for(char c : count.keySet())
        {
            pq.add(new Element(c, 0, count.get(c)));
        }
        
        
        int res = 1;
        
        while(!pq.isEmpty())
        {
            PriorityQueue<Element> temp = new PriorityQueue<Element>(new ElementComp());
            int min = Integer.MAX_VALUE;
            Element e = pq.poll();
            while(e.time>res)
            {
                temp.add(e);
                min = Math.min(min, e.time);
                if(!pq.isEmpty())
                    e = pq.poll();
                else
                    break;
            }
            
            if(e.time<=res)
            {
                e.time = res + k + 1;
                e.freq--;
                
                if(e.freq!=0)
                {    
                    pq.add(e);
                }
                
                
                
                res++;
            }
            else
            {
                res = min;
            }
            
            while(!temp.isEmpty())
            {
                pq.add(temp.poll());
            }
            
            
        }

        return res-1;
        
        
    }
}

class Element
{
    char task;
    int time;
    int freq;
    Element(char task, int time, int freq)
    {
        this.task = task;
        this.time = time;
        this.freq = freq;
    }
}
class ElementComp implements Comparator<Element>
{
    public int compare(Element e1, Element e2)
    {
        if(e1.freq<e2.freq)
            return 1;
        else if(e1.freq>e2.freq)
            return -1;
        else
            return e1.time<e2.time ? 1 : ( e1.time>e2.time ? -1 : e2.task-e1.task );
    }
}