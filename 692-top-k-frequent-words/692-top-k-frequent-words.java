import java.util.Comparator;
import java.util.TreeSet;
class Solution 
{
    public List<String> topKFrequent(String[] words, int k) 
    {
        List<String> res = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<>();
        TreeSet<Element> set = new TreeSet<Element>(new EleComp());
        
        for(String w : words)
        {
            if(map.containsKey(w))
                map.put(w, map.get(w) + 1);
            else
                map.put(w, 1);
        }
        
        for(String w : map.keySet())
        {
            Element e = new Element(w, map.get(w));
            set.add(e);
        }
        int i = 0;
        for(Element e : set)
        {
            //System.out.println(e.w + "  " + e.val);
            if(i<k)
            {
                res.add(e.w);
                i++;
            }
        }
        return res;
    }
}


class Element
{
    String w;
    int val;
    
    Element(String w, int val)
    {
        this.w = w;
        this.val = val;
    }
}
class EleComp implements Comparator<Element>
{
    public int compare(Element e1, Element e2)
    {
        if(e1.val>e2.val)
            return -1;
        else if(e1.val<e2.val)
            return 1;
        return (e1.w).compareTo(e2.w);
    }
}