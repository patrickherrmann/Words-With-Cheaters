import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryLoader
{

   public static TrieNode loadDictionary(String filename, int minWordLen, int maxWordLen)
   {
      TrieNode root = new TrieNode(' ');
      try
      {
         BufferedReader br = new BufferedReader(new FileReader(filename));
         String word;
         while ((word = br.readLine()) != null)
         {
            if (word.length() >= minWordLen && word.length() <= maxWordLen)
            {
               root.addWord(word.toLowerCase());
            }
         }
      }
      catch (IOException e)
      {
         System.out.println(e);
      }
      return root;
   }

   public static TrieNode loadDictionary(String filename)
   {
      return DictionaryLoader.loadDictionary(filename, 1, 1000);
   }
}
