import java.util.Scanner;

public class Palindrome
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a word to check if it is a palindrome: ");
    String word = sc.nextLine();
    String reversedWord = "";
    
    for (int i = word.length() - 1; i >= 0; i--) {
      reversedWord += word.substring(i, i + 1);
    }
    
    if (word.equals(reversedWord)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}