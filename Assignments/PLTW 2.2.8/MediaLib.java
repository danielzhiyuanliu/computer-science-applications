/**
 * Activity 2.2.7
 * * A MediaLib class for the MediaLibrary program
 */
public class MediaLib
{
  public static String owner = "PLTW";

  public static String getOwner() {
    return owner;
  }

  private static int NumEntries = 0;
  private static int NumBooks = 0;
  private static int NumMovies = 0;
  private static int NumSongs = 0;

  public static int getNumEntries() {
    // System.out.println("Test: Owner is " + owner);
    // System.out.println("Test: MediaLib is " + this.book);
    return NumEntries;
  }

  /*
  public static String changeOwner() {
    owner = "Me";
    return owner;
  }
   */
  
  private Book book;
  private Movie movie;
  private Song song;

  public void addBook(Book b)
  {
    if (book == null) {
      book = b;
      NumBooks++;
      NumEntries++;
    } else {
      System.out.println("You can't add more than one book to the library.");
    }
  }
  
  public void addMovie(Movie m)
  {
    if (movie == null) {
      movie = m;
      NumMovies++;
      NumEntries++;
    } else {
      System.out.println("You can't add more than one movie to the library.");
    }
  }

  public void addSong(Song s)
  {
    if (song == null) {
      song = s;
      NumSongs++;
      NumEntries++;
    } else {
      System.out.println("You can't add more than one song to the library.");
    }
  }

  /*public Book getBook()
  {
    return book;
  }
  
  public Movie getMovie()
  {
    return movie;
  } */

  public String toString() 
  {
    String info = "My Library:\n";
    
    if (book == null) {
      info += "- Book: Not defined\n";
    } else {
      info += "- Book: " + book.toString() + "\n";
    }
    
    if (movie == null) {
      info += "- Movie: Not defined\n";
    } else {
      info += "- Movie: " + movie.toString();
    }

    if (song == null) {
      info += "- Song: Not defined";
    } else {
      info += "- Song: " + song.toString();
    }
    
    return info;
  }
  
  public void testBook(Book tester)
  {
    tester.setTitle("Testing Alias Change");
    System.out.println("  Inside testBook: Title changed to '" + tester.getTitle() + "'");
  }
}