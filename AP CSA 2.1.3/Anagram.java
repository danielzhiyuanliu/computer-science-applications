import java.util.Scanner;

public class Anagram
{
  public static void main(String[] args)
  {
    Scanner newScanner = new Scanner(System.in);
    
    System.out.println("Enter two strings to check for anagrams: ");
    String inputOne = newScanner.nextLine();
    String inputTwo = newScanner.nextLine();

    if (areAnagrams(inputOne, inputTwo)) {
      System.out.println(inputOne + " and " + inputTwo + " are anagrams.");
    } else {
      System.out.println(inputOne + " and " + inputTwo + " are not anagrams.");
    }
  }

  public static boolean areAnagrams(String stringOne, String stringTwo)
  {
    if (stringOne.length() != stringTwo.length()) {
      return false;
    }

    String tempOne = stringOne;
    String tempTwo = stringTwo;

    while (tempOne.length() > 0)
    {
      String firstChar = tempOne.substring(0, 1);
      
      int index = tempTwo.indexOf(firstChar);

      if (index != -1)
      {
        tempOne = tempOne.substring(1);
        tempTwo = tempTwo.substring(0, index) + tempTwo.substring(index + 1);
      }
      else
      {
        return false;
      }
    }

    return true;
  }
}