/*
 * Activity 2.2.9
 *
 * A Movie class for the MediaLibrary program
 */
public class Movie
{
  private String title;
  private double duration;
  private int rating;
  
  /*** Constructor ****/
  public Movie(String t, double d)
  {
    title = t;
    duration = d;
    rating = 0;
  }
  
   /*** Accessor methods ***/
  public String getTitle() {
    return title;
  }

  public double getDuration() {
    return duration;
  }
  
  public int getRating() {
    return rating;
  }
  
  public String toString() 
  {
    String info = "\"" + title + "\", duration " + duration + " hours";
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

  public void setDuration(double d) {
    duration = d;
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
  
  public boolean equals(Movie m)
  {
    if (title.equals(m.title) && duration == m.duration) {
      return true;
    }
    return false;
  }
}