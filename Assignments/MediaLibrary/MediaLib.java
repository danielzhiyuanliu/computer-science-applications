/**
 * Activity 2.2.7
 * * A MediaLib class for the MediaLibrary program
 */
public class MediaLib
{
  private Book book;
  private Movie movie;

  public void addBook(Book b)
  {
    book = b;
  }
  
  public void addMovie(Movie m)
  {
    movie = m;
  }

  public Book getBook()
  {
    return book;
  }
  
  public Movie getMovie()
  {
    return movie;
  }

  public String toString() 
  {
    String info = "My Library:\n";
    
    if (book == null) {
      info += "- Book: Not defined\n";
    } else {
      info += "- Book: " + book.toString() + "\n";
    }
    
    if (movie == null) {
      info += "- Movie: Not defined";
    } else {
      info += "- Movie: " + movie.toString();
    }
    
    return info;
  }
  
  public void testBook(Book tester)
  {
    tester.setTitle("Testing Alias Change");
    System.out.println("  Inside testBook: Title changed to '" + tester.getTitle() + "'");
  }
}