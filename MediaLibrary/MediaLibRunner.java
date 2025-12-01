/*
 * Activity 2.2.7
 * * The runner for the MediaLib program
 */
public class MediaLibRunner
{
  public static void main(String[] args)
  {
    System.out.println("Welcome to your Media Library");
    MediaLib myLib = new MediaLib();

    Book myBook = new Book("Lord of the Rings", "Tolkien");
    System.out.println("Book created " + myBook);

    System.out.println("Library (before addBook):\n" + myLib);
    myLib.addBook(myBook);
    System.out.println("Library (after addBook):\n" + myLib);
    
    int myRating = 5;
    myBook.adjustRating(myRating);
    myBook.adjustRating(6);
    myBook.adjustRating(-15);
    
    myBook.setTitle("The Hobbit");
    myBook.setAuthor("J.R.R. Tolkien");
    
    Book currBook = myLib.getBook();
    currBook.setTitle("The Silmarillion"); 
    
    MediaLib myLib2 = new MediaLib();
    Book newBook = new Book("To Kill a Mockingbird", "Lee");
    myLib2.addBook(newBook); 
    newBook = new Book("1984", "Orwell"); 
    
    Book newBook2 = new Book("1984", "Orwell"); 
    newBook2.setTitle("Animal Farm");
    newBook2.setTitle("1984"); 
    newBook2.setAuthor("George Orwell");

    Movie myMovie = new Movie("Dune", 2.5);
    myMovie.adjustRating(8);
    
    myLib.addMovie(myMovie);
    System.out.println("\nLibrary State:");
    System.out.println(myLib);
    
    Movie myMovie2 = new Movie("Dune", 2.5);
    myMovie2.setDuration(3.0);
  }
}