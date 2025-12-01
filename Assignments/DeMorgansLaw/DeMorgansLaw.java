import java.util.Scanner;

public class DeMorgansLaw
{
  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter 'true' or 'false' for A");
    boolean a = sc.nextBoolean(); 

    System.out.println("Enter 'true' or 'false' for B");
    boolean b = sc.nextBoolean();
    
    System.out.println("\n--- Validating First Part of De Morgan's Law ---");
    System.out.println("A: " + a + ", B: " + b);
    
    boolean expr1_part1 = !(a && b);
    System.out.print("Result of !(a && b): ");
    if (expr1_part1) 
    {
      System.out.println("true");
    } 
    else 
    {
      System.out.println("false");
    }
    
    boolean expr2_part1 = (!a || !b);
    System.out.print("Result of (!a || !b): ");
    if (expr2_part1) 
    {
      System.out.println("true");
    } 
    else 
    {
      System.out.println("false");
    }

    if (expr1_part1 == expr2_part1)
    {
        System.out.println("Confirmation: !(a && b) IS equal to (!a || !b) for these inputs.");
    }
    else
    {
        System.out.println("Confirmation: ERROR - !(a && b) IS NOT equal to (!a || !b) for these inputs.");
    }

    
    System.out.println("\n--- Validating Second Part of De Morgan's Law ---");
    System.out.println("A: " + a + ", B: " + b);
    
    boolean expr1_part2 = !(a || b);
    System.out.print("Result of !(a || b): ");
    if (expr1_part2) 
    {
      System.out.println("true");
    } 
    else 
    {
      System.out.println("false");
    }
    
    boolean expr2_part2 = (!a && !b);
    System.out.print("Result of (!a && !b): ");
    if (expr2_part2) 
    {
      System.out.println("true");
    } 
    else 
    {
      System.out.println("false");
    }
    
    if (expr1_part2 == expr2_part2)
    {
        System.out.println("Confirmation: !(a || b) IS equal to (!a && !b) for these inputs.");
    }
    else
    {
        System.out.println("Confirmation: ERROR - !(a || b) IS NOT equal to (!a && !b) for these inputs.");
    }

    sc.close();
  }
}