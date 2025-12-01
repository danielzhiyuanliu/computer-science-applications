import java.util.Scanner;

public class Dyslexia
{
  public static void main(String[] args)
  {
    Scanner newScanner = new Scanner(System.in);
    System.out.println("Enter a String: ");
    String input = newScanner.nextLine();
    String output = "";
    
    for (int i = 0; i < input.length(); i++) {
      String currentCharStr = input.substring(i, i + 1);
      
      if (currentCharStr.equals("d") || currentCharStr.equals("b") || currentCharStr.equals("p") || currentCharStr.equals("q") ||
          currentCharStr.equals("D") || currentCharStr.equals("B") || currentCharStr.equals("P") || currentCharStr.equals("Q")) {
        
        int randIndex = (int)(Math.random() * 4);
        String replacementCharStr;
        
        if (randIndex == 0) {
          replacementCharStr = "d";
        } else if (randIndex == 1) {
          replacementCharStr = "b";
        } else if (randIndex == 2) {
          replacementCharStr = "p";
        } else {
          replacementCharStr = "q";
        }
        
        if (currentCharStr.equals(currentCharStr.toUpperCase())) {
          replacementCharStr = replacementCharStr.toUpperCase();
        }
        output += replacementCharStr;
      } else {
        output += currentCharStr;
      }
    }
    System.out.println("Original string: " + input);
    System.out.println("String after replacing d, b, p, q: " + output);
  }
}