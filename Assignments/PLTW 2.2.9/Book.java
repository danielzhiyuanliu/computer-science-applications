/*
 * Activity 2.2.9
 */
public class Book
{
  private int rating;
  private String title;
  private String author;

  /*** Constructor ****/
  public Book(String title, String author)
  {
    this.title = title;
    this.author = author;
    this.rating = 0;
  }
  
  /*** Accessor methods ***/
  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getRating() {
    return rating;
  }
  
  public boolean equals(Book b)
  {
    if(this.title.equals(b.title) && this.author.equals(b.author))
      return true;  
      
    return false;
  }

  public String toString() 
   {
     String info = "\"" + title + "\", written by " + author;
     if (rating != 0) 
       info += ", rating is " + rating;
     
     return info;
   }

  /*** Mutator methods ***/
  public void setAuthor(String a) {
    author = a;
  }
    
  public void setTitle(String t) {
    title = t;
  }

  // Corrected adjustRating method (Fixes variable hiding error)
  public void adjustRating(int r)
  {
    int newRating = this.rating + r;
    
    if (newRating >= 0 && newRating <= 10) 
    {
      this.rating = newRating;
    } else if (newRating < 0) {
      this.rating = 0;
    } else {
      this.rating = 10;
    }
  }
}