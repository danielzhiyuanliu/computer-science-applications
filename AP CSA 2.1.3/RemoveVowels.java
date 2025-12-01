import java.util.Scanner;

public class RemoveVowels
{
  public static void main(String[] args)
  {
    Scanner newScanner = new Scanner(System.in);
    System.out.println("Enter a String: ");
    String input = newScanner.nextLine();
    String output = "";
    
    for (int i = 0; i < input.length(); i++) {
      String currentCharStr = input.substring(i, i + 1);
      
      if (!currentCharStr.equals("a") && !currentCharStr.equals("e") && !currentCharStr.equals("i") &&
          !currentCharStr.equals("o") && !currentCharStr.equals("u") &&
          !currentCharStr.equals("A") && !currentCharStr.equals("E") && !currentCharStr.equals("I") &&
          !currentCharStr.equals("O") && !currentCharStr.equals("U")) {
        output += currentCharStr;
      }
    }
    
    System.out.println("Original string: " + input);
    System.out.println("String after removing vowels: " + output);
  }
}