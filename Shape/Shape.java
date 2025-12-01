class Shape
{
  String shapeOf="";
  int numOfSides;
  
  public void setShape(String x, int y)
  {
    shapeOf=x;
    numOfSides = y;
  }
  
  public String getShape()
  {
    return shapeOf + " with " + numOfSides + " sides";
  }
  
  public int getSides()
  {
    return numOfSides;
  }
  
  public boolean equals(Object other)
  {
     if (other == null || getClass() != other.getClass()) 
     {
        return false;
     }
     
     if (this == other) {
        return true;
     }

     Shape s = (Shape) other;
     
     if (s.shapeOf.equals(shapeOf) && s.numOfSides == numOfSides)
     {
       return true;
     }
     return false;
  }
}
