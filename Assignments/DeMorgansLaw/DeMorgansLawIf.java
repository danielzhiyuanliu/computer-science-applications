/*
 * Activity 1.3.6
 */
import java.util.Scanner;

public class DeMorgansLawIf
{
  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter 'true' or 'false' for A");
    boolean a = sc.nextBoolean(); 

    System.out.println("Enter 'true' or 'false' for B");
    boolean b = sc.nextBoolean();
    
    System.out.println("\n--- Original Expression (1): !(a && b) ---");
    if (!(a && b))
    {
      System.out.println("NOT (a AND b) evaluates to true");
    }
    else 
    {
      System.out.println("NOT (a AND b) evaluates to false");
    }
    
    /* Reproducing the logic of !(a && b) using nested if/else */
    System.out.println("--- Nested If/Else (1) for !(a && b) ---");
    if (a) // If A is true
    {
        if (b) // If B is true (A AND B is TRUE)
        {
            // The result of !(a && b) is FALSE
            System.out.println("NOT (a AND b) evaluates to false");
        }
        else // If B is false (A AND B is FALSE)
        {
            // The result of !(a && b) is TRUE
            System.out.println("NOT (a AND b) evaluates to true");
        }
    }
    else // If A is false (A AND B is FALSE)
    {
        // Regardless of B, a && b is false, so !(a && b) is TRUE
        System.out.println("NOT (a AND b) evaluates to true");
    }
     
     
    System.out.println("\n--- Original Expression (2): !(a || b) ---");
    if (!(a || b))
    {
      System.out.println("NOT (a OR b) evaluates to true");
    }
    else 
    {
      System.out.println("NOT (a OR b) evaluates to false");
    }
    
     /* Reproducing the logic of !(a || b) using nested if/else */
     System.out.println("--- Nested If/Else (2) for !(a || b) ---");
     if (a) // If A is true (A OR B is TRUE)
     {
         // Regardless of B, a || b is true, so !(a || b) is FALSE
         System.out.println("NOT (a OR b) evaluates to false");
     }
     else // If A is false
     {
         if (b) // If B is true (A OR B is TRUE)
         {
             // The result of !(a || b) is FALSE
             System.out.println("NOT (a OR b) evaluates to false");
         }
         else // If B is false (A OR B is FALSE)
         {
             // The result of !(a || b) is TRUE
             System.out.println("NOT (a OR b) evaluates to true");
         }
     }
    
    sc.close();
  }
}