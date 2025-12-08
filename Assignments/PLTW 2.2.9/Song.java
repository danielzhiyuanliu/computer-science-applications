/*
 * Activity 2.2.9
 *
 * A Song class for the MediaLibrary program
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
  
  public Song(String t)
  {
    title = t;
    author = "Unknown";
    rating = 0;
  }
  
   /*** Accessor methods ***/
  public String getTitle() {
    return title;
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
  }
  
  public boolean equals(Song s)
  {
    if (title.equals(s.title)) {
      return true;
    }
    return false;
  }
}