import java.util.ArrayList;

public class TrieNode
{

   private char letter;
   private boolean terminates;
   private ArrayList<TrieNode> children;

   public TrieNode(char letter)
   {
      this.letter = letter;
      terminates = false;
      children = new ArrayList<TrieNode>();
   }

   public void addWord(String word)
   {
      if (word.length() == 0)
      {
         terminates = true;
         return;
      }
      for (int i = 0; i < children.size(); i++)
      {
         if (children.get(i).letter == word.charAt(0))
         {
            children.get(i).addWord(word.substring(1));
            return;
         }
      }

      TrieNode firstLetter = new TrieNode(word.charAt(0));
      children.add(firstLetter);
      firstLetter.addWord(word.substring(1));
   }
   
   public boolean contains(String word)
   {
      if (word.length() == 0) return true;
      for (TrieNode child : children)
      {
         if (child.letter == word.charAt(0))
         {
            return child.contains(word.substring(1));
         }
      }
      return false;
   }

   public ArrayList<String> getWords()
   {
      ArrayList<String> words = new ArrayList<String>();
      processNode(words, "");
      return words;
   }

   private void processNode(ArrayList<String> words, String fragment)
   {
      fragment += letter;
      if (terminates)
      {
         words.add(fragment);
      }
      for (int i = 0; i < children.size(); i++)
      {
         children.get(i).processNode(words, fragment);
      }
   }

   /**
    * @return the letter
    */
   public char getLetter()
   {
      return letter;
   }

   /**
    * @return the terminates
    */
   public boolean isTerminates()
   {
      return terminates;
   }

   /**
    * @return the children
    */
   public ArrayList<TrieNode> getChildren()
   {
      return children;
   }
}
