/*
 * Activity 1.3.6
 */
import java.util.Scanner; 

public class DeMorgansLawGTlT
{
  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter a number for X (e.g., -5, 0, or 10)");
    // Corrected to nextInt() to read numbers
    int x = sc.nextInt();

    System.out.println("Enter a number for Y (e.g., -5, 0, or 10)");
    // Corrected to nextInt() to read numbers
    int y = sc.nextInt(); 
    
    System.out.println("\nChecking that both x and y are not negative (i.e., x >= 0 AND y >= 0)... ");
    System.out.println("X: " + x + ", Y: " + y);

    // Original expression: !(x < 0) AND !(y < 0)
    System.out.print("Result using the original AND expression: ");
    if (!(x < 0) && !(y < 0)) {
      System.out.println("TRUE: Both x and y are not negative.");
    } else {
      System.out.println("FALSE: At least one number is negative.");
    }
    
    // Equivalent expression using a logical OR: !((x < 0) || (y < 0))
    // This reproduces the logic of the previous expression using an OR operator.
    System.out.print("Result using the De Morgan's Law OR expression: ");
    if (!((x < 0) || (y < 0))) {
      System.out.println("TRUE: Both x and y are not negative.");
      
      /* * Short-circuit evaluation could occur with the '||' (OR) operator:
       * * If the left operand, (x < 0), evaluates to 'true' 
       * (meaning x is negative), the overall OR expression, (x < 0) || (y < 0),
       * is guaranteed to be true. 
       * * In this specific true case, the Java runtime environment will 
       * 'short-circuit' and skip evaluating the right operand (y < 0), 
       * since the result of the OR expression is already determined.
       */
    } else {
      System.out.println("FALSE: At least one number is negative.");
    }
    
    sc.close();
  }
}
