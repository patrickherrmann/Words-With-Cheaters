import java.util.Scanner;

public class ScrabbleHelper
{
   public static void main(String[] args)
   {
      Permuter p = new Permuter("wordlist.txt");
      Scanner in = new Scanner(System.in);
      
      System.out.println("Select an option from the menu:");
      System.out.println(" -- find words in your letters (w)");
      System.out.println(" -- find words using possible crosses (c)");
      System.out.println(" -- check dictionary for word (d)");
      System.out.println(" -- quit (q)");
      
      boolean quit = false;
      
      while (!quit)
      {
         System.out.println("Enter a menu option:");
         switch (in.nextLine().charAt(0))
         {
            case 'w':
               System.out.println("Enter the letters to permute (ex. tfreeo* where * is the blank tile):");
               p.printArrayList(p.getPermutations(in.next()));
               in.nextLine();
               break;
            case 'c':
               System.out.println("Enter the letters to permute (ex. tfreeo* where * is the blank tile)");
               System.out.println("followed by the possible letters to cross (ex. xeuotr):");
               p.printWithCrosses(in.next(), in.next());
               in.nextLine();
               break;
            case 'd':
               System.out.println("Enter a word to look up:");
               System.out.println(p.isWord(in.next()) ? "It's a word!" : "Not a word");
               in.nextLine();
               break;
            case 'q':
               quit = true;
               break;
            default:
               System.out.println("Invalid menu choice.");
         }
      }
   }
   
}
