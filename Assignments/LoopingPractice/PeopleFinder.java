public class PeopleFinder {
    
    static People[] peopleList = {new People("Samuel", 19), 
        new People("Trista", 24), 
        new People("Carlos", 50), 
        new People("Michael", 87), 
        new People("Trenton", 39), 
        new People("Amber", 4), 
    };

    static int selectPerson = 24;
    public static void main(String args[]) {
        for (int i = 0; i < peopleList.length; i++) {
            if (peopleList[i].getAge() == (selectPerson)) {
                System.out.println(peopleList[i].getName());
                break;
            }
        }
    }
}
