/*
 * Activity 2.1.3
 */
import java.util.Scanner;

 public class RemoveEveryOther
{
  public static void main(String[] args)
  {
    Scanner newScanner = new Scanner(System.in);
    System.out.println("Enter a String: ");
    String input = newScanner.nextLine();
    String output = new String("");
    
    for (int i = 0; i < input.length(); i+=2) {
      output += input.substring(i, i+1);
    }
    
    System.out.println("Original string: " + input);
    System.out.println("String after newScannerremoving every other character: " + output.toString());
  }
}