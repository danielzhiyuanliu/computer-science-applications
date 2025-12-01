import java.util.Scanner;

public class OrderUp
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter how many numbers you want to input: ");
    int count = sc.nextInt();
    
    if (count <= 0) {
      System.out.println("Please enter a positive integer.");
      return;
    }
    
    System.out.println("Enter " + count + " numbers: ");
    
    int firstNumber = sc.nextInt();
    int min = firstNumber;
    int max = firstNumber;
    
    for (int i = 1; i < count; i++) {
      int currentNumber = sc.nextInt();
      
      if (currentNumber < min) {
        min = currentNumber;
      }
      
      if (currentNumber > max) {
        max = currentNumber;
      }
    }
    
    System.out.println("Lowest number: " + min);
    System.out.println("Highest number: " + max);
    
    sc.close();
  }
}