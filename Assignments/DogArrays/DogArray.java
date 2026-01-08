/*
 * Activity 3.1.1
 */
public class DogArray
{
  public static void main(String[] args)
  {
    Dog[] myDogs = {new Dog("Lady"),
               new Dog("Tramp"),
                new Dog("Trusty")};
    Dog[] neighborsDogs = new Dog[2];

    System.out.println(myDogs[0].getName());
    System.out.println(myDogs[1].getName());
    System.out.println(myDogs[2].getName());

    neighborsDogs[0] = new Dog("neighborsDogs1");
    neighborsDogs[1] = new Dog("neighborsDogs2");

    System.out.println(neighborsDogs[0].getName());
    System.out.println(neighborsDogs[1].getName());

    Dog[] friendsDogs = {new Dog("Lady"), new Dog("Tramp")};
    System.out.println(friendsDogs[0] + " and " + friendsDogs[1]);
  }
}