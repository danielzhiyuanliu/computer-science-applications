/*
 * Activity 2.1.1
 */
import java.util.Scanner;

public class SumAndAverage
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of values to sum and average: ");
    int numValues = sc.nextInt();
    int sum = 0;
    
    for (int i = 0; i < numValues; i++) {
        System.out.println("Enter value " + (i + 1) + ": ");
        int input = sc.nextInt();
        
        while (input == 0) {
            System.out.println("Only non-zero values, please try again.");
            System.out.println("Enter value " + (i + 1) + ": ");
            input = sc.nextInt();
        }
        
        sum += input;
    }
    
    double average = (double) sum / numValues;
    
    System.out.println("Sum: " + sum);
    System.out.println("Average: " + average);
    
    sc.close();
  }
}