public class ShapeEquals
{
  public static void main(String[] args) 
  {
    Shape shape1 = new Shape();
    shape1.setShape("Triangle", 3);
  
    Shape shape2 = new Shape();
    shape2.setShape("Square", 4);
  
    Shape shape3 = shape1;
    shape3.setShape("Hexagon", 6);
    
    Shape shape4 = new Shape();
    shape4.setShape("Square", 4); 

    System.out.println("--- Final Shape States ---");
    System.out.println("Shape 1: " + shape1.getShape());
    System.out.println("Shape 2: " + shape2.getShape());
    System.out.println("Shape 3: " + shape3.getShape());
    System.out.println("Shape 4: " + shape4.getShape());
    
    System.out.println("\n--- Reference Comparisons (==) ---");

    System.out.println("Shape 1 == Shape 2: " + (shape1 == shape2)); 

    System.out.println("Shape 2 == Shape 3: " + (shape2 == shape3)); 

    System.out.println("Shape 1 == Shape 3: " + (shape1 == shape3)); 
    
    System.out.println("Shape 4 == Shape 1: " + (shape4 == shape1));

    System.out.println("Shape 4 == Shape 2: " + (shape4 == shape2)); 
    
    System.out.println("Shape 4 == Shape 3: " + (shape4 == shape3)); 

    System.out.println("\n--- Logical Comparisons (equals()) ---");
    
    System.out.println("Shape 1 equals Shape 2: " + shape1.equals(shape2)); 

    System.out.println("Shape 1 equals Shape 3: " + shape1.equals(shape3)); 

    System.out.println("Shape 1 equals Shape 4: " + shape1.equals(shape4)); 

    System.out.println("Shape 2 equals Shape 4: " + shape2.equals(shape4)); 

    System.out.println("Shape 2 equals Shape 3: " + shape2.equals(shape3)); 

    System.out.println("Shape 3 equals Shape 4: " + shape3.equals(shape4)); 
  }
}
