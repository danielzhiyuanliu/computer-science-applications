/*
 * Activity 2.2.9
 */
public class MediaLibRunnerFinal
{
  public static void main(String[] args)
  {
    System.out.println("--- Library Initialization ---");
    
    MediaLib myLib = new MediaLib();
    System.out.println("Library 1 created. Initial Date: " + DateUtils.getDateTime());
    
    // Test the first library
    myLib.addBook(new Book("1984", "Orwell"));
    myLib.addMovie(new Movie("Raiders of the Lost Ark", 1.9));
    
    System.out.println("\n--- Library 1 Final State ---");
    System.out.println(myLib);

    // Create a second library
    MediaLib myLib2 = new MediaLib();
    System.out.println("Library 2 created. Initial Date: " + DateUtils.getDateTime());

    // Test the second library
    myLib2.addSong(new Song("In Your Eyes", "Peter Gabriel"));
    
    System.out.println("\n--- Library 2 Final State ---");
    System.out.println(myLib2);
    
    System.out.println("Total number of entries in all libraries: " + MediaLib.getNumEntries());
    
    // Demonstrate static change
    MediaLib.changeOwner("The Students");
    System.out.println("New Owner: " + MediaLib.getOwner());
  }
}