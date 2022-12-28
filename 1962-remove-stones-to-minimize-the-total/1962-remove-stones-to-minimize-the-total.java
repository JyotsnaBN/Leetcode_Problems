class Solution 
{
    public int minStoneSum(int[] arr, int k) 
    {
        SortedSet<Element> set = new TreeSet<Element> (new EleComp());
        int n = arr.length;
        for(int i = 0; i<n; i++)
            set.add(new Element(arr[i], i));
        
        Element e;
        int el;
        
        while(k>0)
        {
            k--;
            e = set.first();
            set.remove(e);
            
       
            el = e.a;
            el = el%2 == 0 ? el : el+1;
            el/=2;

            set.add(new Element(el, e.b));
        }
        
        int res = 0;
        
        for(Element E : set)
            res += E.a;

        
        return res;
        
        
    }
}
class Element
{
    int a, b;
    public Element(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
}
class EleComp implements Comparator<Element>
{
    public int compare(Element e1, Element e2)
    {
        if(e1.a == e2.a)
            return e1.b - e2.b;
        return e2.a-e1.a;
    }
}