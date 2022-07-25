class FoodRatings 
{
    HashMap<String, Food> foodList = new HashMap<>();//Store food name and the object Food
    HashMap<String, TreeSet<Food>> map = new HashMap<>();//Store cuisine and set of Food objects
    
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) 
    {
        for(int i = 0; i<foods.length; i++)
        {
            Food ob = new Food(foods[i], cuisines[i], ratings[i]);
            foodList.put(foods[i], ob);

            if(map.containsKey(cuisines[i]))
            {
                map.get(cuisines[i]).add(ob);
            }
            else
            {
                TreeSet<Food> temp = new TreeSet<Food>();
                temp.add(ob);
                map.put(cuisines[i], temp);
            }
        }
    }
    
    public void changeRating(String food, int newRating) 
    {
        Food ob = foodList.get(food);
        boolean var = map.get(ob.cuisine).remove(ob);        
        ob.rating = newRating;
        map.get(ob.cuisine).add(ob);     
    }
    
    public String highestRated(String cui) 
    {
        return map.get(cui).last().food;
    }
}

public class Food implements Comparable<Food>
{
    final String food;
    final String cuisine;
    int rating;
    Food(String f, String c, int r)
    {
        food = f;
        cuisine = c;
        rating = r;
    }
    public int compareTo(Food ob)
    {
        if(rating>ob.rating)
            return 1;
        else if(rating<ob.rating)
            return -1;
        else
        {
            if(ob.food.compareTo(food)>0)
                return 1;
            else if(ob.food.compareTo(food)<0)
                return -1;
            else
                return 0;
                
        }
    }
}



/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */

