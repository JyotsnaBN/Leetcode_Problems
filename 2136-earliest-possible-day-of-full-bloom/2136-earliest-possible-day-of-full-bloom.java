class Solution 
{
    public int earliestFullBloom(int[] p, int[] g) 
    {
        int n = p.length;
        int max = 0;
        
        List<Element> list = new ArrayList<Element>();
        
        for(int i = 0; i<n; i++)
        {
            list.add(new Element(p[i], g[i]));
        }
        
        Collections.sort(list, new EleComp());
        
        int prev = 0;
        for(Element e : list)
        {    
            //System.out.println(e.x + " " + e.y);
            int x = e.x, y = e.y;
            prev += x;
            
            int temp = prev + y + 1;
            max = Math.max(max, temp);
        }
         
        return max - 1;
        
        
    }
}

class Element
{
    int x;
    int y;
    Element(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

class EleComp implements Comparator<Element>
{
    public int compare(Element e1, Element e2)
    {
        if(e1.y>e2.y)
            return -1;
        else if(e1.y<e2.y)
            return 1;
        else
        {
            if(e1.x>e2.x)
                return -1;
            else if(e1.x<e2.x)
                return 1;
        }
        return 0;
    }
}