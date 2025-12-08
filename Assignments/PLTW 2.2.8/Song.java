/*
 * Activity 2.2.7
 *
 * A Book class for the MediaLibrary program
 */
public class Song
{
  private String title;
  private String author;
  private int rating;
  
  /*** Constructor ****/
  public Song(String t, String a)
  {
    title = t;
    author = a;
    rating = 0;
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
  
  public String toString() 
  {
    String info = "\"" + title + "\", sung by " + author;
    if (rating != 0) 
    { 
      info += ", rating is " + rating;
    }
    return info;
  }

  /*** Mutator methods ***/
  public void setTitle(String t) {
    title = t;
  }

  public void setAuthor(String a) {
    author = a;
  }
  
  public void adjustRating(int r) 
  {
    int newRating = rating + r;
    
    if (newRating >= 0 && newRating <= 10) 
    {
        rating = newRating;
    } else if (newRating < 0) {
        rating = 0;
    } else {
        rating = 10;
    }
    
    r = 999;
  }
  
  public boolean equals(Song s)
  {
    if (title.equals(s.title) && author.equals(s.author)) {
      return true;
    }
    return false;
  }
}