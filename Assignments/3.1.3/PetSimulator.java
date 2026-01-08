/*
 * Activity 3.1.3
 */
public class PetSimulator
{
  public static void main(String[] args)
  {
    // create an array that can hold up to 10 pets (does not require looping)

    Pet[] petsList = new Pet[10];
    
    // adopt (create and name) four pets, two cats, two dogs (does not require looping)

    petsList[0] = new Pet("Daisy", 1);
    petsList[1] = new Pet("Animalia", 1);
    petsList[2] = new Pet("Rutherford", 2);
    petsList[3] = new Pet("Eris", 2);

    // first things first, feed your pets

    for (int i = 0; i < petsList.length; i++) {
      if (petsList[i] == null) {
        break;
      } petsList[i].feed();
    }

    // next, make yourself the owner of all of your new pets

    for (int i = 0; i < petsList.length; i++) {
      if (petsList[i] == null) {
        break;
      } 
      
      petsList[i].setOwner("Daniel");
      System.out.println(petsList[i].getOwner());
    } 

    // your dogs make some noise, take them for a walk

    for (int k = 0; k < petsList.length; k++) {
      if (petsList[k] == null) {
        break;
      } petsList[k].walk();
    } 

    // when you get back, your cats make some noise

    for (int k = 0; k < petsList.length; k++) {
      if (petsList[k] == null) {
        break;
      } 
      
      if (petsList[k].getType() == 1) {
        petsList[k].makeNoise();
      }
    } 
    
    // give all of your pets a treat

    for (int k = 0; k < petsList.length; k++) {
      if (petsList[k] == null) {
        break;
      } petsList[k].giveTreat();
    } 

    // groom your cats

    for (int k = 0; k < petsList.length; k++) {
      if (petsList[k] == null) {
        break;
      } 
      
      if (petsList[k].getType() == 1) {
        petsList[k].groom();
      }
    } 
 
    // grooming is done, play with all pets

    for (int k = 0; k < petsList.length; k++) {
      if (petsList[k] == null) {
        break;
      } petsList[k].play();
    } 

    // whew, that was tiring, all pets nap and get fed

    for (int k = 0; k < petsList.length; k++) {
      if (petsList[k] == null) {
        break;
      } 
      
      petsList[k].sleep();
      petsList[k].feed();
    } 

    // show the state of all of your pets

    for (int k = 0; k < petsList.length; k++) {
      if (petsList[k] == null) {
        break;
      } System.out.println(petsList[k].toString());
    } 
    
    // You decide to get a couple of pets for your friend (does not require looping)

    petsList[4] = new Pet("Charger", 1);
    petsList[5] = new Pet("Tinkerbell", 2);
    
    // set the owner of the new pets to your friends name

    for (int k = 4; k < petsList.length; k++) {
      if (petsList[k] == null) {
        break;
      } 
      
      petsList[k].setOwner("Abraham"); 
      System.out.println(petsList[k].getOwner());
    } 
    
    // show the state of all of your pets

    for (int k = 0; k < petsList.length; k++) {
      if (petsList[k] == null) {
        break;
      } System.out.println(petsList[k].toString());
    } 

  }
}