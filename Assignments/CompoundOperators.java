/*
 * Activity 1.1.4
 */
public class CompoundOperators
{
  public static void main(String[] args)
  {
    int numPeople = 0;  
    double totalYears = 0;

    double years = 11.5;  // I will soon be halfway through my junior year.

    totalYears += years;
    numPeople++;
    
    System.out.println(years);
    System.out.println(numPeople);
    System.out.println(totalYears);
    
    System.out.println("I have " + years + " years in school.");
    System.out.print("Total people: " + numPeople);
    System.out.println(", total years: " + totalYears);
  }
}