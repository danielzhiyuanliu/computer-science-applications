/**
 * Activity 2.2.9
 * A MediaLib class for the MediaLibrary program
 */
public class MediaLib
{
  public static String owner = "PLTW";
  
  private static int numEntries;
  private static int numBooks;
  private static int numMovies;
  private static int numSongs;
  
  private String lastModified; 
  
  private Book book;
  private Movie movie;
  private Song song;

  public MediaLib()
  {
    this.lastModified = DateUtils.getDateTime();
  }
  
  public void addBook(Book b)
  {
    if (book == null)
    {
      book = b;
      numEntries++;
      numBooks++;
      this.lastModified = DateUtils.getDateTime();
    } 
    else
      System.out.println("Cannot add a new book: A book already exists");
  }
  
  public void addMovie(Movie m)
  {
    if (movie == null)
    {
      movie = m;
      numEntries++;
      numMovies++;
      this.lastModified = DateUtils.getDateTime();
    }
    else
      System.out.println("Cannot add a new movie: A movie already exists");
  }
  
  public void addSong(Song s)
  {
    if (song == null)
    {
      song = s;
      numEntries++;
      numSongs++;
      this.lastModified = DateUtils.getDateTime();
    }
    else
      System.out.println("Cannot add a new song: A song already exists");
  }

  public static String getOwner()
  {
    return owner;
  }

  public static void changeOwner(String o)
  {
    owner = o;
  }
  
  public static int getNumEntries()
  {
    return numEntries;
  }
  
  public static int getNumBooks()
  {
    return numBooks;
  }
  
  public static int getNumMovies()
  {
    return numMovies;
  }
  
  public static int getNumSongs()
  {
    return numSongs;
  }
  
  public String toString() 
  {
    String info = "Library Last Modified: " + this.lastModified + "\n";
    
    if (book != null)
      info += "Book: " + book + "\n";
    if (movie != null)
      info += "Movie: " + movie + "\n";
    if (song != null)
      info += "Song: " + song + "\n";
 
    return info;
  }
}