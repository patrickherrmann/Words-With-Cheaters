import java.util.ArrayList;

public class Permuter
{
   private TrieNode words;
     
   public Permuter(String wordlistFilename)
   {
      words = DictionaryLoader.loadDictionary(wordlistFilename);
   }
   
   public boolean isWord(String word)
   {
      return words.contains(word);
   }
   
   public void printWithCrosses(String letters, String crosses)
   {
      System.out.println("Without crossing letters:");
      printCrosses(getPermutations(letters), ' ');
      for (int i = 0; i < crosses.length(); i++)
      {
         System.out.println("\nCrossing '" + crosses.charAt(i) + "':");
         printCrosses(getPermutations(letters + crosses.charAt(i)), crosses.charAt(i));
      }
   }
   
   public ArrayList<String> getPermutations(String letters)
   {
      ArrayList<String> perms = new ArrayList<String>();
      for (int j = 0; j < words.getChildren().size(); j++)
      {
         permute(words.getChildren().get(j), new String(letters), perms, "");
      }
      return perms;
   }
   
   private void printCrosses(ArrayList<String> perms, char cross)
   {
      if (cross == ' ')
      {
         printArrayList(perms);
      }
      else
      {
         for (int i = perms.size() - 1; i >= 0; i--)
         {
            if (perms.get(i).indexOf(cross) == -1)
            {
               perms.remove(i);
            }
         }
         printArrayList(perms);
      }
   }
   
   public void printArrayList(ArrayList<String> list)
   {
      list = Sorter.mergeSortArrayList(list);
      for (int i = 0; i < list.size(); i++)
      {
         System.out.println(list.get(i));
      }
   }
   
   private void permute(TrieNode node, String letters,
    ArrayList<String> perms, String fragment)
   {
      for (int i = 0; i < letters.length(); i++)
      {
         if (letters.charAt(i) == node.getLetter() || letters.charAt(i) == '*')
         {
            fragment += node.getLetter();
            letters = letters.substring(0, i) + letters.substring(i + 1);
            if (node.isTerminates())
            {
               perms.add(fragment);
            }
            for (int j = 0; j < node.getChildren().size(); j++)
            {
               permute(node.getChildren().get(j), new String(letters), perms, new String(fragment));
            }
            return;
         }
      }
   }
}
