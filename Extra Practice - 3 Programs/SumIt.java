import java.util.Scanner;

public class SumIt
{
  public static void main(String[] args)
  {
    Scanner newScanner = new Scanner(System.in);
    System.out.println("Enter 5 integers to sum: ");
    int num1 = newScanner.nextInt();
    int num2 = newScanner.nextInt();
    int num3 = newScanner.nextInt();
    int num4 = newScanner.nextInt();
    int num5 = newScanner.nextInt();
    
    int sum = num1 + num2 + num3 + num4 + num5;
    
    System.out.println("The sum is: " + sum);
  }
}