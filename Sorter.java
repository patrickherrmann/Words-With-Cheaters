import java.util.ArrayList;

public class Sorter
{
   public static ArrayList<String> mergeSortArrayList(ArrayList<String> a)
   {
      if (a.size() <= 1) return a;
      ArrayList<String> left = new ArrayList<String>(a.size() / 2);
      ArrayList<String> right = new ArrayList<String>(a.size() / 2);
      int i;
      for (i = 0; i < a.size() / 2; i++)
      {
         left.add(a.get(i));
      }
      for (i = a.size() / 2; i < a.size(); i++)
      {
         right.add(a.get(i));
      }
      return merge(mergeSortArrayList(left), mergeSortArrayList(right));
   }
   
   private static ArrayList<String> merge(ArrayList<String> left, ArrayList<String> right)
   {
      int size = left.size() + right.size();
      ArrayList<String> out = new ArrayList<String>(size);
      while (left.size() > 0 || right.size() > 0)
      {
         if (left.size() > 0 && right.size() > 0)
         {
            if (left.get(0).compareTo(right.get(0)) < 0)
            {
               out.add(left.remove(0));
            }
            else
            {
               out.add(right.remove(0));
            }
         }
         else if (left.size() > 0)
         {
            out.addAll(left);
            left.clear();
         }
         else if (right.size() > 0)
         {
            out.addAll(right);
            right.clear();
         }
      }
      return out;
   }
}
