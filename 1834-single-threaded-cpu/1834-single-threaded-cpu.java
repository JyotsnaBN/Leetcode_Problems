class Solution 
{
    public int[] getOrder(int[][] tasks) 
    {
        int n = tasks.length;    
        int k = 0;
        
        Element set[] = new Element[n];
        
        
        for(int i = 0; i<n; i++)
            set[k++] = new Element(i, tasks[i][0], tasks[i][1]);

        Arrays.sort(set, new EleComp1());
        
        
        int res[] = new int[n];
        
        PriorityQueue<Element> pq=new PriorityQueue<>(new EleComp2());
        
        int ai = 0;
        int ti = 0;
        int cur = 0;
        
        while(ai<n)
        {
            while(ti<n && set[ti].b<=cur)
                pq.add(set[ti++]);
            
            
            if(pq.size()==0)
            {
                cur = set[ti].b;
                continue;
            }
            
            Element e = pq.remove();
            res[ai++] = e.a;
            cur += e.c;
        }
        
        return res;
        
    }
}

class Element
{
    int a, b, c;
    Element(int a, int b, int c)
    {
        this.a = a;//index
        this.b = b;//start time
        this.c = c;//processing time
    }
}
class EleComp1 implements Comparator<Element>
{
    public int compare(Element e1, Element e2)
    {
        return e1.b - e2.b;
    }
}
class EleComp2 implements Comparator<Element>
{
    public int compare(Element e1, Element e2)
    {
        if(e1.c == e2.c)
            return e1.a - e2.a;
        return e1.c - e2.c;
    }
}