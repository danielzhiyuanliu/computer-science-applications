/*
 * Activity 2.2.9
 */
public class MediaLibLogic
{
  public static void main(String[] args)
  {
    Book book = new Book("The Lord of the Rings", "Tolkien");
    System.out.println(book);
    book.adjustRating(4);
    System.out.println("new rating: " + book.getRating());    
    book.adjustRating(5);
    System.out.println("new rating: " + book.getRating());    
    book.adjustRating(10);
    System.out.println("new rating (capped): " + book.getRating());
  }
}